package com.model.dao;

import com.model.vo.ProyectoVo;
import com.util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDao {
    public List<ProyectoVo> listar() throws SQLException {
        ArrayList<ProyectoVo> respuesta = new ArrayList<ProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT P.ID_PROYECTO AS ID, P.Constructora AS Constructora, P.Numero_Habitaciones AS Num_Habitaciones, P.Ciudad AS Ciudad"
                + " FROM PROYECTO P"
                + " WHERE P.Clasificacion = 'Casa Campestre' AND P.Ciudad IN ('Santa Marta','Cartagena','Barranquilla')";
        try {
            stmt = conn.prepareStatement(consulta);
            rset = stmt.executeQuery();
            while (rset.next()) {
                ProyectoVo vo = new ProyectoVo();
                vo.setId_proyecto(rset.getInt("ID"));
                vo.setConstructora(rset.getString("Constructora"));
                vo.setNum_habitaciones(rset.getInt("Num_Habitaciones"));
                vo.setCiudad(rset.getString("Ciudad"));

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
