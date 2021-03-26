import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

public class URLGui {
    JDBCWriter jdbcWriter = new JDBCWriter();
    ArrayList<String> urllst;
    JTextField txtUrl;
    JTextField txtLine;
    JLabel lblCount;
    JList lbLines;

    public URLGui() {
        jdbcWriter = new JDBCWriter();
        urllst = new ArrayList<String>();
    }

    public void connectDB() {
        Boolean bb = jdbcWriter.setConnection();
        System.out.println(bb);
    }

    public void retrieveUrl() {
        URLRead urlRead = new URLRead();
        String urlstr = txtUrl.getText();
        urllst = urlRead.readURL(urlstr);
        System.out.println(urllst.size());
        String resSplit = "antal linjer før split=" + urllst.size();
        ArrayList<String> splitlst = new ArrayList<>();
        String splitstr = "<";
        for (String str1: urllst) {
            String[] strArr = str1.split(splitstr);
            int ix = 0;
            for (String str2: strArr) {
                if (ix>0) {
                    str2 = splitstr + str2;
                };
                ix++;
                if (str2.trim().length() > 0) {
                    splitlst.add(str2);
                }
            }
        }
        lblCount.setText(resSplit+ " efter split=" + splitlst.size());
        urllst = splitlst;
        System.out.println(urllst.size());
    }

    public void retrieveUrlUdenSplit() {
        URLRead urlRead = new URLRead();
        String urlstr = txtUrl.getText();
        urllst = urlRead.readURL(urlstr);
        lblCount.setText("arraylist size=" + urllst.size());
    }

    public void saveToDb(ActionEvent ae) {
        System.out.println(ae);
        String url = txtUrl.getText();
        int rowcount = jdbcWriter.writeLines(url, urllst);
        lblCount.setText("JUBII skrevet lines="+rowcount);
    }

    public void searchDb() {
        String url = txtUrl.getText();
        String srch = txtLine.getText();
        int cnt = jdbcWriter.searchDb(url, srch);
        lblCount.setText("" + cnt);
    }

    public void deleteDb() {
        String url = txtUrl.getText();
        String srch = txtLine.getText();
        int cnt = jdbcWriter.deleteDb(url, srch);
        lblCount.setText("" + cnt);
    }

    public void getLines() {
        String url = txtUrl.getText();
        String srch = txtLine.getText();
        Vector<String> v1 = new Vector<>();
        v1.add(url);
        v1.add(srch);
        lbLines.setListData(v1);

    }

    public void regExp() {
        Vector<String> vector = new Vector<>();
        String regexp = txtUrl.getText();
        String strToSplit = txtLine.getText();
        String[] strArr = strToSplit.split(regexp);
        for (String str1: strArr){
            vector.add(str1);
        }
        lblCount.setText(" split=" + vector.size());
        lbLines.setListData(vector);
    }

    public void createGui() {
        JFrame frame = new JFrame("URL Hent GUI");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JButton pbConnect = new JButton("Connect");
        panel.add(pbConnect);
        pbConnect.addActionListener(a -> connectDB());
        JButton pbRetrieveUrl = new JButton("Retrieve url");
        JButton pbSaveToDB = new JButton("Save to DB");
        JButton pbSearch = new JButton("Search");
        JButton pbDelete = new JButton("Delete");
        JButton pbRegExpr = new JButton("Regular Exp");

        panel.add(pbRegExpr);
        panel.add(pbRetrieveUrl);
        panel.add(pbSaveToDB);
        panel.add(pbSearch);
        panel.add(pbDelete);

        txtUrl = new JTextField("", 50);
        lblCount = new JLabel("count");
        txtLine = new JTextField("", 70);
        panel.add(txtUrl);
        panel.add(lblCount);
        panel.add(txtLine);
        pbRetrieveUrl.addActionListener(a -> retrieveUrl());
        pbSaveToDB.addActionListener((ActionEvent ae)-> saveToDb(ae));
        pbSearch.addActionListener(a -> searchDb());
        pbDelete.addActionListener(a -> deleteDb());
        pbRegExpr.addActionListener(a -> regExp());

        //bundpanel til listbox
        JPanel panelBottom = new JPanel();
        JButton pbGetLines = new JButton("Get lines");
        frame.getContentPane().add(panelBottom, BorderLayout.SOUTH);
        panelBottom.add(pbGetLines);
        lbLines = new JList();
        panelBottom.add(lbLines);
        pbGetLines.addActionListener(a -> getLines());

        Vector<String> v1 = new Vector<>();
        v1.add("hej do");
        v1.add("nr 2 linje");
        v1.add("nr 3 linje adsfadsfasd");
        v1.add("4444444444444444444444");
        lbLines.setListData(v1);

        // Show Main Window
        frame.pack();
        frame.setBounds(100, 100, 800, 400);
        frame.setVisible(true);

    }
}
