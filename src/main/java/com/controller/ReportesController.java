package com.controller;

import com.model.dao.LiderDao;
import com.model.dao.ProyectoDao;
import com.model.dao.CompraDao;
import com.model.vo.LiderVo;
import com.model.vo.ProyectoVo;
import com.model.vo.CompraVo;

import java.sql.SQLException;
import java.util.List;

public class ReportesController {
    private CompraDao compraDao;
    private LiderDao liderDao;
    private ProyectoDao pagadoPorProyectoDao;

    public ReportesController() {
        compraDao = new CompraDao();
        liderDao = new LiderDao();
        pagadoPorProyectoDao = new ProyectoDao();
    }

    public List<CompraVo> listarProyectosPorBanco() throws SQLException {
        return compraDao.listar();
    }

    public List<ProyectoVo> listarTotalAdeudadoProyectos() throws SQLException {
        return pagadoPorProyectoDao.listar();
    }

    public List<LiderVo> listarLideresQueMasGastan() throws SQLException {
        return liderDao.listar();
    }
}
