package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementStter {
    void setter(PreparedStatement pstmt) throws SQLException;
}
