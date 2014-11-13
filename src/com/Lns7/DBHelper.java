package com.Lns7;

import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.servlet.http.*;
import org.logicalcobwebs.proxool.*;

public class DBHelper extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {

		/*
		 * Connection conn = null; PreparedStatement pstmt = null; conn =
		 * getConnect(); try { java.util.Date dt = new Date();
		 * utilityHelper.Date2String(dt);
		 * System.out.println(utilityHelper.Date2String(dt)); pstmt =
		 * conn.prepareStatement("insert into users(id,regTime)values('"+
		 * utilityHelper.getUUID() +"',?)"); pstmt.setTimestamp(1,new
		 * Timestamp((new Date()).getTime())); //pstmt.setDate(1, new
		 * java.sql.Date(dt.getTime())); //PrepareCommand(pstmt, params);
		 * System.out.println(pstmt.executeUpdate());
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { try { if
		 * (pstmt != null && (!pstmt.isClosed())) pstmt.close(); if (conn !=
		 * null && (!conn.isClosed())) conn.close(); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */

		// Object[] p = new Object[1];
		// p[0] = 43269;
		// ExecuteNonQuery("insert into users(id,name,password,regTime,studentId) values(?,?,?,?,?)",new
		// Object[]{utilityHelper.getUUID(),"谢军","1234567",utilityHelper.getNowDate(),"x008517"});

		// System.out.println(getResultSetCount("select * from users where studentId=? and password=?",new
		// Object[]{"x008517","1234567"}));

		// System.out.println(utilityHelper.getUUID().length());

		/*
		 * ArrayList<Object[]> arr =
		 * ExecuteReader("select top 10 ID,znm,znmc,td,tel,bjrq,scheck2 from nwdx"
		 * ,null); for (int i = 0; i < arr.size(); i++) { Object[] bb =
		 * arr.get(i); System.out.println("===================="); for (int j =
		 * 0; j < bb.length; j++) { if(j==0){ System.out.println(bb[j]); } } }
		 */
		// ArrayList<Object[]> arr =
		// ExecuteReader("select top 10 ID,znm,znmc,td,tel,bjrq,scheck2 from nwdx",null);
		// for(Object[] o:arr){
		// Object[] s = new Object[];
		// ResultSetMetaData[] = (s[]);

		// Object[] sa = o;

		// sa

		// System.out.println(o[1]);
		/*
		 * for(Object c:s){ //ResultSetMetaData vvv = (ResultSetMetaData) zz;
		 * 
		 * System.out.println(c);
		 * 
		 * }
		 */
		// }

		// System.out.println(ExecuteReader("select top 10 * from nwdx",null));
	}

	/*
	 * private static Connection _connect = null; private static String _driver
	 * = null; private static String _url = null; private static String _user =
	 * null; private static String _pwd = null;
	 */

	private static ProxoolDataSource ds = null;

	/**
	 * 获得数据库连接
	 * 
	 * @return
	 */
	private static Connection getConnect() {
		/*
		 * try { if (_connect == null || _connect.isClosed()) { _driver =
		 * "com.mysql.jdbc.Driver"; _url =
		 * "jdbc:mysql://127.0.0.1:3306/RUC?useUnicode=true&characterEncoding=UTF8"
		 * ; _user = "root"; _pwd = "123456"; Class.forName(_driver); _connect =
		 * DriverManager.getConnection(_url, _user, _pwd); }
		 * 
		 * return _connect; } catch (Exception e) { return null; }
		 */

		ds = new ProxoolDataSource();
		ds.setDriver("com.mysql.jdbc.Driver");
		//ds.setDriverUrl("jdbc:mysql://127.0.0.1:3306/RUC?useUnicode=true&characterEncoding=UTF8");
		ds.setDriverUrl("jdbc:mysql://220.181.134.98:3306/RUC?useUnicode=true&characterEncoding=UTF8");
		ds.setUser("root");
		//ds.setPassword("123456");
		ds.setPassword("FHuma025");
		ds.setAlias("dbconn");
		ds.setMaximumConnectionCount(8);
		ds.setMinimumConnectionCount(2);
		ds.setMaximumActiveTime(5);
		ds.setHouseKeepingTestSql("select * from users");
		Connection _connect = null;
		try {
			_connect = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return _connect;
	}

	/**
	 * 获取执行指定sql语句后的返回结果集的记录条数
	 * 
	 * @param sql
	 *            要执行的SQL命令拼装语句字符串
	 * @return 查询结果得到的记录条数
	 * @throws Exception
	 */
	public static int getResultSetCount(String sql, Object[] params) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			PrepareCommand(pstmt, params);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	/**
	 * 用于执行语句（eg：insert语句，update语句，delete语句）
	 * 
	 * @param String
	 *            cmdtext,SQL语句
	 * @param OracleParameter
	 *            [] params,参数集合
	 * @return int,SQL语句影响的行数
	 */
	public static int ExecuteNonQuery(String cmdtext, Object[] params) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(cmdtext);
			PrepareCommand(pstmt, params);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 用于获取结果集语句（eg：selete * from table）
	 * 
	 * @param cmdtext
	 * @param params
	 * @return ResultSet
	 * @throws Exception
	 */
	public static ArrayList<Object[]> ExecuteReader(String cmdtext,Object[] params) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ArrayList<Object[]> al = new ArrayList<Object[]>();
		try {
			conn = getConnect();
			pstmt = conn.prepareStatement(cmdtext);
			PrepareCommand(pstmt, params);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();

			while (rs.next()) {
				Object[] ob = new Object[column];
				for (int i = 1; i <= column; i++) {
					ob[i - 1] = rs.getObject(i);
					
				}
				al.add(ob);
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * 用于获取首行首列值语句（用名字指定字段）
	 * 
	 * @param cmdtext
	 *            SQL语句
	 * @param name
	 *            列名
	 * @param params
	 *            OracleParameter[]
	 * @return Object
	 * @throws Exception
	 */
	public static Object ExecuteScalar(String cmdtext, String name,Object[] params) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			pstmt = conn.prepareStatement(cmdtext);
			PrepareCommand(pstmt, params);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getObject(name);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	/**
	 * 用于获取首行首列值语句（用序号指定字段）
	 * 
	 * @param cmdtext
	 *            SQL语句
	 * @param index
	 *            列名索引
	 * @param params
	 *            OracleParameter[]
	 * @return Object
	 * @throws Exception
	 */
	public static Object ExecuteScalar(String cmdtext, int index,Object[] params) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			pstmt = conn.prepareStatement(cmdtext);
			PrepareCommand(pstmt, params);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getObject(index);
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	/**
	 * 准备SQL参数
	 * 
	 * @param pstm
	 * @param params
	 */
	public static void PrepareCommand(PreparedStatement pstm, Object[] params) {
		if (params == null || params.length == 0) {
			return;
		}

		try {
			for (int i = 0; i < params.length; i++) {
				int parameterIndex = i + 1;
				if (params[i] == null) {
					pstm.setNull(parameterIndex, Types.NULL);
				} else if (params[i].getClass() == String.class) {
					pstm.setString(parameterIndex, params[i].toString());
				}
				else if (params[i].getClass() == short.class) {
					pstm.setShort(parameterIndex,Short.parseShort(params[i].toString()));
				}
				else if (params[i].getClass() == Long.class) {
					pstm.setLong(parameterIndex,Long.parseLong(params[i].toString()));
				}
				else if (params[i].getClass() == Integer.class) {
					pstm.setInt(parameterIndex,Integer.parseInt(params[i].toString()));
				}
				else if (params[i].getClass() == Date.class) {
					java.util.Date dt = (java.util.Date) params[i];
					pstm.setDate(parameterIndex,new java.sql.Date(dt.getTime()));
				} else if (params[i].getClass() == Timestamp.class) {
					java.util.Date dt = (java.util.Date) params[i];
					pstm.setTimestamp(parameterIndex,new Timestamp(dt.getTime()));
				}
				else if (params[i].getClass() == byte.class) {
					pstm.setByte(parameterIndex, (Byte) params[i]);
				}
				else if (params[i].getClass() == float.class) {
					pstm.setFloat(parameterIndex,Float.parseFloat(params[i].toString()));
				}
				else if (params[i].getClass() == boolean.class) {
					pstm.setBoolean(parameterIndex,Boolean.parseBoolean(params[i].toString()));
				} else {
					throw new Exception("参数准备出错:数据类型不可见"+ params[i].getClass().toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
