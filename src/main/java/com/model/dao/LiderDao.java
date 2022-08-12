package com.model.dao;

import com.model.vo.LiderVo;
import com.util.JDBCUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LiderDao {
    public List<LiderVo> listar() throws SQLException {
        ArrayList<LiderVo> respuesta = new ArrayList<LiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT L.ID_LIDER AS ID, L.Nombre AS Nombre, L.Primer_Apellido AS Apellido,L.Ciudad_Residencia AS Ciudad"
        +" FROM LIDER L"
        +" ORDER BY Ciudad";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
            while (rset.next()) {
                LiderVo vo = new LiderVo();
                vo.setId_lider(rset.getInt("ID"));
                vo.setNombre(rset.getString("Nombre"));
                vo.setPrimer_Apellido(rset.getString("Apellido"));
                vo.setCiudad_residencia(rset.getString("Ciudad"));

                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
