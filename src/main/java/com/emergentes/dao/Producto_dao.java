package com.emergentes.dao;

import com.emergentes.modelo.DProducto;
import java.util.List;

public interface Producto_dao {

    public void insert(DProducto productos) throws Exception;
    public void update(DProducto productos) throws Exception;
    public void delete(int id) throws Exception;
    public DProducto getByid(int id) throws Exception;
    public List<DProducto> getAll() throws Exception;

}
