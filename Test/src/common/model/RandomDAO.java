package common.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.bean.RandomBean;

public class RandomDAO {

	private static RandomDAO instance;
	private RandomDAO() {}

	public static RandomDAO getInstance() {
		if (instance == null) {
			instance = new RandomDAO();
		}
		return instance;
	}

	public void updateRandom(RandomBean bean) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("UPDATE RANDOM SET "
					+ "RANDOM1=?,RANDOM2=?,RANDOM3=?,RANDOM4=?,RANDOM5=?,RANDOM6=?,RANDOM7=?,RANDOM8=? "
					+ "WHERE SEQ=?");
			connection = DBConnection.getConnection();
			System.out.println(query);
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query.toString());
			preparedStatement.setString(1, bean.getRandom1());
			preparedStatement.setString(2, bean.getRandom2());
			preparedStatement.setString(3, bean.getRandom3());
			preparedStatement.setString(4, bean.getRandom4());
			preparedStatement.setString(5, bean.getRandom5());
			preparedStatement.setString(6, bean.getRandom6());
			preparedStatement.setString(7, bean.getRandom7());
			preparedStatement.setString(8, bean.getRandom8());
			preparedStatement.setString(9, bean.getSeq());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					DBConnection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public RandomBean read(String seq) {
		RandomBean randomBean = new RandomBean();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT*FROM RANDOM WHERE SEQ=?");
			connection = DBConnection.getConnection();
			System.out.println(query);
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(query.toString());
			preparedStatement.setString(1, seq);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				randomBean.setSeq(resultSet.getString(1));
				randomBean.setRandom1(resultSet.getString(2));
				randomBean.setRandom2(resultSet.getString(3));
				randomBean.setRandom3(resultSet.getString(4));
				randomBean.setRandom4(resultSet.getString(5));
				randomBean.setRandom5(resultSet.getString(6));
				randomBean.setRandom6(resultSet.getString(7));
				randomBean.setRandom7(resultSet.getString(8));
				randomBean.setRandom8(resultSet.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					DBConnection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return randomBean;
	}

}