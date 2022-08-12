package com.model.dao;

import com.model.vo.CompraVo;
import com.util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDao {
        public List<CompraVo> listar() throws SQLException {
            ArrayList<CompraVo> respuesta = new ArrayList<CompraVo>();
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement stmt = null;
            ResultSet rset = null;
            String consulta = "SELECT c.ID_Compra AS ID, p.Constructora AS Constructora, p.Banco_Vinculado AS Banco"
            		+ " FROM Compra c"
            		+ " INNER JOIN Proyecto p ON p.ID_Proyecto = c.ID_Proyecto"
            		+ " WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";
            try {
                stmt = conn.prepareStatement(consulta);
                rset = stmt.executeQuery();
                while (rset.next()) {
                    CompraVo vo = new CompraVo();
                    vo.setId_Compra(rset.getInt("ID"));
                    vo.setConstructora(rset.getString("Constructora"));
                    vo.setBanco_Vinculado(rset.getString("Banco"));
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

