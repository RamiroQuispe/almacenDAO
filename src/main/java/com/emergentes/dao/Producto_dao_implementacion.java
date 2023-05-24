package com.emergentes.dao;
import com.emergentes.modelo.DProducto;
import com.emergentes.utiles.Conexion_bd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Producto_dao_implementacion extends Conexion_bd implements Producto_dao {

    @Override
    public void insert(DProducto producto) throws Exception {
        try {
            this.conectar();
            String sql = "insert into productos(descripcion,cantidad,precio,categoria) values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setString(2, producto.getCantidad());
            ps.setInt(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(DProducto producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion = ?, cantidad =?, precio =? , categoria =?  WHERE id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setString(2, producto.getCantidad());
            ps.setInt(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public DProducto getByid(int id) throws Exception {
        DProducto avi = new DProducto();
        try {
            this.conectar();
            String sql = "select * from productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setCantidad(rs.getString("cantidad"));
                avi.setPrecio(rs.getInt("precio"));
                avi.setCategoria(rs.getString("categoria"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<DProducto> getAll() throws Exception {

        ArrayList<DProducto> lista = new ArrayList<DProducto>();
        try {
            this.conectar();
            String sql = "select * from productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DProducto avi = new DProducto();
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setCantidad(rs.getString("cantidad"));
                avi.setPrecio(rs.getInt("precio"));
                avi.setCategoria(rs.getString("categoria"));

                lista.add(avi);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
