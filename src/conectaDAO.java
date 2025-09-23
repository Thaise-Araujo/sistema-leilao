
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class conectaDAO {
    
    public Connection connectDB(){
    
            
                    try {
                        Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost/loja", // linha de conexao
                                "thaise", // usuario do mysql
                                "123456"// senha do mysql
                        );
                        return conn;
            
                    } catch (Exception e) {
                        System.out.println("Erro ao conectar: " + e.getMessage());
                        return null;
                    }
            
                }
}
