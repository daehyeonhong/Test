package safetia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.DBConnection;

public class CodingTest {

	public static void main(String[] args) {

		int sus_01_p_seq = 2;

		Sus_02 sus_02 = new Sus_02();
		sus_02.setsus_02_p_seq(sus_01_p_seq);
		sus_02.setsus_02_p_name("a");
		sus_02.setsus_02_p_price(1);
		sus_02.setsus_02_p_quantity(1);
		sus_02.setsus_02_p_desc("asd");

		solution(sus_01_p_seq, sus_02);
	}

	private static void solution(int sus_01_p_seq, Sus_02 sus_02) {
		Sus_01 sus_01 = search(sus_01_p_seq);

		if (sus_01 != null) {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = null;
			String searchSus_02 = "SELECT SUS_02_P_SEQ FROM SUS_02 WHERE SUS_02_P_SEQ=?";
			try {
				preparedStatement = connection.prepareStatement(searchSus_02);
				preparedStatement.setInt(1, sus_01.getSus_01_p_seq());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					preparedStatement.close();
					System.out.printf("%d번 제품 정보 업데이트", sus_01.getSus_01_p_seq());
					System.out.println(fork(0, sus_01, sus_02) != 0 ? "성공" : "실패");
				} else {
					preparedStatement.close();
					System.out.printf("%d번 제품 정보 입력", sus_01.getSus_01_p_seq());
					System.out.println(fork(1, sus_01, sus_02) != 0 ? "성공" : "실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (preparedStatement != null && !preparedStatement.isClosed()) {
						preparedStatement.close();
					}
					DBConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.printf("제품번호 %d 제품에 대한 정보가 없습니다.", sus_01_p_seq);
		}
	}

	private static Sus_01 search(int sus_01_p_seq) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;

		String searchSus_01 = "SELECT SUS_01_P_SEQ,SUS_01_P_NAME,SUS_01_P_PRICE,SUS_01_P_QUANTITY,SUS_01_P_DESC FROM SUS_01 WHERE SUS_01_P_SEQ=?";
		Sus_01 sus_01 = null;
		try {
			preparedStatement = connection.prepareStatement(searchSus_01);
			preparedStatement.setInt(1, sus_01_p_seq);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sus_01 = new Sus_01();
				sus_01.setSus_01_p_seq(resultSet.getInt(1));
				sus_01.setSus_01_p_name(resultSet.getString(2));
				sus_01.setSus_01_p_price(resultSet.getInt(3));
				sus_01.setSus_01_p_quantity(resultSet.getInt(4));
				sus_01.setSus_01_p_desc(resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sus_01;
	}

	private static int fork(int key, Sus_01 sus_01, Sus_02 sus_02) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			if (key == 0) {
				String updateQuery = "UPDATE SUS_02 SET SUS_02_P_NAME=?,SUS_02_P_PRICE=?,SUS_02_P_QUANTITY=?,SUS_02_P_DESC=? WHERE SUS_02_P_SEQ=?";
				preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, sus_02.getsus_02_p_name());
				preparedStatement.setInt(2, sus_02.getsus_02_p_price());
				preparedStatement.setInt(3, sus_02.getsus_02_p_quantity());
				preparedStatement.setString(4, sus_02.getsus_02_p_desc());
				preparedStatement.setInt(5, sus_02.getsus_02_p_seq());
				result = preparedStatement.executeUpdate();
			} else {
				String insertQuery = "INSERT INTO SUS_02(SUS_02_P_SEQ,SUS_02_P_NAME,SUS_02_P_PRICE,SUS_02_P_QUANTITY,SUS_02_P_DESC)VALUES(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(insertQuery);
				preparedStatement.setInt(1, sus_01.getSus_01_p_seq());
				preparedStatement.setString(2, sus_01.getSus_01_p_name());
				preparedStatement.setInt(3, sus_01.getSus_01_p_price());
				preparedStatement.setInt(4, sus_01.getSus_01_p_quantity());
				preparedStatement.setString(5, sus_01.getSus_01_p_desc());
				result = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}