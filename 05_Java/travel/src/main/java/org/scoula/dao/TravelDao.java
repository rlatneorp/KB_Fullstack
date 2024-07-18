package org.scoula.dao;

import org.scoula.domain.TravelImageVO;
import org.scoula.domain.TravelVO;

import java.sql.SQLException;

public interface TravelDao {
    void create(TravelVO travel) throws SQLException;

    void createImage(TravelImageVO image) throws SQLException;
}