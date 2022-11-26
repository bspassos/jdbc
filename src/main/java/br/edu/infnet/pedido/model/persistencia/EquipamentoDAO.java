package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Equipamento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO extends JdbcDAO<Equipamento> {

    public EquipamentoDAO() {

    }

    @Override
    public Boolean salvar(Equipamento equipamento) {
        String sql = "insert into equipamento(nome, mensalidade, id) values (?, ?,null)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, equipamento.getNome()); //sql injection
            pstm.setFloat(2, equipamento.getMensalidade()); //sql injection
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean atualizar(Equipamento equipamento) {
        String sql = "update equipamento set nome = ?, mensalidade = ? where id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, equipamento.getNome());
            pstm.setFloat(2, equipamento.getMensalidade());
            pstm.setLong(3, equipamento.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Equipamento equipamento) {
        String sql = "delete from equipamento where id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, equipamento.getId());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Equipamento obter(Long codigo) {
        String sql = "select * from equipamento where id = ?";
        Equipamento equipamento = new Equipamento();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()) {
                String nome = rs.getString("nome");
                Float idDB = rs.getFloat("id");
                equipamento = new Equipamento(nome, idDB);
            }
            return equipamento;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipamento> listarTodos() {
        String sql = "select * from equipamento";
        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                String nome = rs.getString("nome");
                Float mensalidade = rs.getFloat("mensalidade");
                Long id = rs.getLong("id");
                Equipamento equipamento = new Equipamento(nome, mensalidade, id);
                equipamentos.add(equipamento);
            }
            return equipamentos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
