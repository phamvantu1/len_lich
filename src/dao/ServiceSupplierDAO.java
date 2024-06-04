package dao;

import model.Service;
import model.ServiceSupplier;
import model.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceSupplierDAO extends DAO{
    public ServiceSupplierDAO() {
        super();
    }

    public List<ServiceSupplier> getAllServiceSupplierByService(Service service) {
        List<ServiceSupplier> result = new ArrayList<>();
        try {
            String sqlServiceSupplier = "SELECT * FROM tblservicesupplier WHERE id_service = ?";
            String sqlSupplier = "SELECT * FROM tblsupplier WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sqlServiceSupplier);
            statement.setInt(1, service.getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ServiceSupplier serviceSupplier = new ServiceSupplier();
                serviceSupplier.setId(rs.getInt("id"));
                serviceSupplier.setType(rs.getString("type"));
                serviceSupplier.setPrice(rs.getInt("price"));
                serviceSupplier.setService(service);

                int id_supplier = rs.getInt("id_supplier");
                statement = con.prepareStatement(sqlSupplier);
                statement.setInt(1, id_supplier);
                ResultSet rsSupplier = statement.executeQuery();
                if(rsSupplier.next()) {
                    Supplier supplier = new Supplier();
                    supplier.setId(rsSupplier.getInt("id"));
                    supplier.setName(rsSupplier.getString("name"));
                    supplier.setEmail(rsSupplier.getString("email"));
                    supplier.setTel(rsSupplier.getString("tel"));
                    supplier.setNote(rsSupplier.getString("note"));

                    serviceSupplier.setSupplier(supplier);
                }
                result.add(serviceSupplier);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
