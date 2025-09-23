import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class vendasVIEW extends JFrame {

    private JTable tabelaVendidos;
    private DefaultTableModel modelo;

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Valor", "Status"}, 0);
        tabelaVendidos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabelaVendidos);

        add(scrollPane);
        carregarVendidos();
    }

    private void carregarVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> vendidos = new ArrayList<>(dao.listarProdutosVendidos());

        modelo.setRowCount(0); // Limpa a tabela
        for (ProdutosDTO p : vendidos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getValor(),
                p.getStatus()
            });
        }
    }
}