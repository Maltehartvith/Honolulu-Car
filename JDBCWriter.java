import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class JDBCWriter {

    Connection connection;

    public boolean setConnection() {
        String url = "jdbc:mysql://localhost:3306/urlreaddb?serverTimezone=UTC";
        boolean res = false;
        try {
            connection = DriverManager.getConnection(url, "Emil", "Kjo3qpr#");
            res = true;
        } catch (SQLException sqlerr) {
            System.out.println("Fejl i connect =" + sqlerr.getMessage());
        }
        return res;
    }

    public int writeLines(String aUrl, ArrayList<String> aLst) {
        String insstr = "INSERT INTO urlread(url, line, linelen) values (?, ?, length(line))";
        PreparedStatement preparedStatement;
        int rowcount = 0;
        try {
            for (String line : aLst) {
                if ((line.length()>0) && (line.length()<=15000)){
                    line = line.trim();
                    preparedStatement = connection.prepareStatement(insstr);
                    preparedStatement.setString(1, aUrl);
                    preparedStatement.setString(2, line);
                    int ii = preparedStatement.executeUpdate();
                    rowcount++;
                    if (rowcount % 200 == 0) {
                        System.out.println("Har saved rowcount=" + rowcount + " url=" + aUrl);
                    }
                } else {
                    System.out.println("Line kunne ikke gemmes len=" + line.length());
                }
            }
        } catch (SQLException sqlerr)   {
            System.out.println("fejl i insert=" + sqlerr.getMessage());
        }
        return rowcount;
    }

    public int searchDb(String aUrl, String aLine) {
        String srcstr = "select count(*) from urlread where url like ? and line like ?";
        PreparedStatement preparedStatement;
        int res = -1;
        try {
            preparedStatement = connection.prepareStatement(srcstr);
            preparedStatement.setString(1, "%" + aUrl + "%");
            preparedStatement.setString(2, "%" + aLine + "%");
            ResultSet resset = preparedStatement.executeQuery();
            if (resset.next()) {
                String str = "" + resset.getObject(1);
                res = Integer.parseInt(str);
            }
        } catch (SQLException sqlerr) {
            System.out.println("FEJL i søg =" + sqlerr.getMessage());
        }
        return res;
    }

    public Vector<String> getLines(String aUrl, String aLine) {
        String srcstr = "SELECT left(line, 20) as line FROM urlread WHERE url like ? and line like ?";
        PreparedStatement preparedStatement;
        Vector<String> v1 = new Vector<>();
        try {
            preparedStatement = connection.prepareStatement(srcstr);

        } catch (SQLException sqlerr) {
            System.out.println("FEJL i getLines" + sqlerr.getMessage());
        }
        return v1;
    }


    public int deleteDb(String aUrl, String aLine) {
        String delstr = "delete from urlread where url like ? and line like ?";
        PreparedStatement preparedStatement;
        int res = -1;
        try {
            preparedStatement = connection.prepareStatement(delstr);
            preparedStatement.setString(1, "%" + aUrl + "%");
            preparedStatement.setString(2, "%" + aLine + "%");
            res = preparedStatement.executeUpdate();
        } catch (SQLException sqlerr) {
            System.out.println("FEJL i delete =" + sqlerr.getMessage());
        }
        return res;
    }
}


