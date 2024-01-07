import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tb_pbo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void createPelanggan(Hewan hewan) {
        try (Connection connection = connect()) {
            String query = "INSERT INTO pelanggan (faktur, nama_pelanggan, no_hp, jumlah_hewan, total_harga, nama_kasir) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, hewan.faktur);
                preparedStatement.setString(2, hewan.namaPelanggan);
                preparedStatement.setString(3, hewan.noHp);
                preparedStatement.setInt(4, hewan.jumlahHewan);
                preparedStatement.setInt(5, hewan.totalBayar);
                preparedStatement.setString(6, hewan.namaKasir);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Hewan> getAllPelanggan() {
        LinkedList<Hewan> pelangganList = new LinkedList<>();

        try (Connection connection = connect()) {
            String query = "SELECT * FROM pelanggan";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String faktur = resultSet.getString("faktur");
                    String namaPelanggan = resultSet.getString("nama_pelanggan");
                    String noHp = resultSet.getString("no_hp");

                    Hewan pelanggan = new Hewan(faktur, namaPelanggan, noHp);
                    pelangganList.add(pelanggan);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelangganList;
    }

    public static void updatePelanggan(String faktur, String newName) {
        try (Connection connection = connect()) {
            String query = "UPDATE pelanggan SET nama_pelanggan = ? WHERE faktur = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newName);
                preparedStatement.setString(2, faktur);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePelanggan(String faktur) {
        try (Connection connection = connect()) {
            String query = "DELETE FROM pelanggan WHERE faktur = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, faktur);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
