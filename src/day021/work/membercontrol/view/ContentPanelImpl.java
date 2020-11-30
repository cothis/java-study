package day021.work.membercontrol.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ContentPanelImpl extends ContentPanel{

    JTable jTable;

    public ContentPanelImpl(JFrame jFrame) {
        setGeometry();

        String[] header = {"번호", "이름", "나이", "키"};
        String[][] content = {
                {"1", "홍길동", "13", "183"},
                {"2", "일지매", "18", "168"}
        };

        jTable = new JTable(content, header);
        jTable.setFont(this.getFont());
        
        //Table 내용 가운데 정렬
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = jTable.getColumnModel();
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(cellRenderer);
        }

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(5, 5, this.getWidth() - 10, this.getHeight() - 10);
        add(jScrollPane);
    }
}
