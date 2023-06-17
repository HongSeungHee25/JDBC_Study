package koreait.jdbc.day5.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koreait.jdbc.day2.OracleUtility;

public class MoneyDAO {

	// 회원매출정보 추가
    public void addMoney(MoneyDTO money) throws SQLException {
    	Connection connection = OracleUtility.getConnection();
        String query = "INSERT INTO money_tbl_02 (custno, salenol, pcost, amount, price, pcode, sdate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, money.getCustno());
            statement.setInt(2, money.getSalenol());
            statement.setInt(3, money.getPcost());
            statement.setInt(4, money.getAmount());
            statement.setInt(5, money.getPrice());
            statement.setString(6, money.getPcode());
            statement.setDate(7, money.getSdate());

            statement.executeUpdate();
        }
    }

    // 회원매출정보 조회
    public List<MoneyDTO> getMoneyList() throws SQLException {
    	Connection connection = OracleUtility.getConnection();
        List<MoneyDTO> moneyList = new ArrayList<>();

        String query = "SELECT custno, salenol, pcost, amount, price, pcode, sdate FROM money_tbl_02";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                MoneyDTO money = new MoneyDTO();
                money.setCustno(resultSet.getInt("custno"));
                money.setSalenol(resultSet.getInt("salenol"));
                money.setPcost(resultSet.getInt("pcost"));
                money.setAmount(resultSet.getInt("amount"));
                money.setPrice(resultSet.getInt("price"));
                money.setPcode(resultSet.getString("pcode"));
                money.setSdate(resultSet.getDate("sdate"));

                moneyList.add(money);
            }
        }

        return moneyList;
    }

    // 기타 필요한 메서드들을 추가로 구현할 수 있습니다.
}