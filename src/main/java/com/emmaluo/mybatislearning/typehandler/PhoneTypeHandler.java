package com.emmaluo.mybatislearning.typehandler;

import com.emmaluo.mybatislearning.model.PhoneNumber;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zcluo on 2016/6/24.
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

    public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.getAsString());
    }

    public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return new PhoneNumber(rs.getString(columnName));
    }

    public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return new PhoneNumber(rs.getString(columnIndex));
    }

    public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new PhoneNumber(cs.getString(columnIndex));
    }
}
