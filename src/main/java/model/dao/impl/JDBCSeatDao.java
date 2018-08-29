package model.dao.impl;

import java.sql.Connection;
import java.util.List;

public class JDBCSeatDao implements SeatDao {
    private Connection connection;

    public JDBCSeatDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(Seat entity) {

    }

    @Override
    public Seat findById(int id) {
        return null;
    }

    @Override
    public List<Seat> findAll() {
        return null;
    }

    @Override
    public void updateSeat(Seat entity) {

    }

    @Override
    public void deleteSeat(int id) {

    }

    @Override


}
