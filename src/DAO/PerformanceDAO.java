package DAO;

import java.sql.*;
import java.util.Vector;

import DTO.OpenPerformanceDTO;
import DTO.PerformanceDTO;
import DTO.StageExhibitionDTO;
import DTO.StagePerformanceDTO;
import main.DB;

public class PerformanceDAO {
	//TODO: �̰� ����ȵǸ� =null ���ֱ�!!!
	private DB getCon;
	private Connection conn;
	//private Statement stmt;
	private PreparedStatement psmt;
	private Statement stmt;
	private ResultSet rs;	//�ȵ��ư��� null

	private void connect() {
		this.conn = this.getCon.loadConnection();
	}

	// ��ü ���� ��ȸ
	public Vector<PerformanceDTO> totalInquiryPerformance() {
		connect();
		Vector<PerformanceDTO> pfList = new Vector<PerformanceDTO>();
		PerformanceDTO pf;
		try {

			String sql = "select * from performance";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				pf = new PerformanceDTO();
				pf.setName(rs.getString("name"));
				pf.setTime(rs.getInt("time"));
				pf.setType(rs.getString("type"));
				pfList.addElement(pf);
			}
			return pfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	public OpenPerformanceDTO inquiryPerformanceOP(String name) {//////////////////////////
		connect();
		OpenPerformanceDTO pf = new OpenPerformanceDTO();
		try {
			String sql = "select * from open_performance where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			rs.next();
			pf.setOpened(rs.getInt("opened"));

			return pf;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	
	// ������,�� - ������ȸ
	public PerformanceDTO inquiryPerformance(String name) {
		connect();
		PerformanceDTO pf = new PerformanceDTO();
		try {
			String sql = "select * from performance where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			rs.next();
			pf.setName(rs.getString("name"));
			pf.setTime(rs.getInt("time"));
			pf.setType(rs.getString("type"));

			return pf;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	// ������ �̸� �ߺ� üũ
	public boolean checkSPName(String name) {	//������ ��� �ߺ�üũ
		connect();
		try {
			String sql = "select * from performance_stage where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			if(rs.next()) return true;	//�ߺ��� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;//�ߺ����� ���� ��� false��ȯ
	}
	// ������ �̸� �ߺ� üũ2
	public boolean checkSPName2(String name) {	//������ ����,���� �ߺ�üũ
		connect();
		try {
			String sql = "select * from performance_stage where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			if(!rs.next()) return true;	//�ߺ��� �ƴ� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;//�ߺ����� ���� ��� false��ȯ
	}



	// ���� - �̸� ����
	public boolean updateName(String name, String originalName) {
		connect();
		try {
			String sql = "update performance set name = ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, originalName);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	
	// ���� - �������� ����
		public boolean updateAll(String type, int time, String name) {
			connect();
			try {
				String sql = "update performance set type = ?, time = ? where name = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, type);
				psmt.setInt(2, time);
				psmt.setString(3, name);
				int check = psmt.executeUpdate();

				if(check == 1) return true;
				else return false;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return false;
		}

	// ���� - �������� ����
	public boolean updateType(String type, String name) {
		connect();
		try {
			String sql = "update performance set type = ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, type);
			psmt.setString(2, name);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ���� - �����ð� ����
	public boolean updateTime(int time, String name) {
		connect();
		try {
			String sql = "update performance set time = ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, time);
			psmt.setString(2, name);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	// �������� op ����
		public boolean deletePerformanceWithOP(String name) {
			connect();
			try {
				String sql = "delete from performance where name = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				int check = psmt.executeUpdate();
				
				sql = "delete from open_performance where name = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				check = psmt.executeUpdate();

				if(check == 1) return true;
				else return false;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return false;
		}
	
	// ��������
	public boolean deletePerformance(String name) {
		connect();
		try {
			String sql = "delete from performance where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ��ü ������� ��ȸ
	public Vector<OpenPerformanceDTO> totalInquiryOpenPerformance() {
		connect();
		Vector<OpenPerformanceDTO> opfList = new Vector<OpenPerformanceDTO>();
		OpenPerformanceDTO opf;
		try {

			String sql = "select * from open_performance";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				opf = new OpenPerformanceDTO();
				opf.setPno(rs.getInt("pno"));
				opf.setName(rs.getString("name"));
				opf.setPlace(rs.getString("place"));
				opf.setSdate(rs.getString("sdate"));
				opf.setEdate(rs.getString("edate"));
				opf.setStime(rs.getString("stime"));
				opf.setPriceSeatR(rs.getInt("priceSeatR"));
				opf.setPriceSeatS(rs.getInt("priceSeatS"));
				opf.setPriceSeatA(rs.getInt("priceSeatA"));
				opf.setId(rs.getString("id"));
				opf.setOpened(rs.getInt("opened"));

				opfList.addElement(opf);
			}
			return opfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	// ������ ������� ��ȸ
	public OpenPerformanceDTO aaadminInquiryOpenPerformance(String admin) {
		connect();
		OpenPerformanceDTO opf = new OpenPerformanceDTO();
		try {
			String sql = "select * from open_performance where admin = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, admin);
			rs = psmt.executeQuery();

			rs.next();
			opf.setPno(rs.getInt("pno"));
			opf.setSdate(rs.getString("sdate"));
			opf.setEdate(rs.getString("edate"));
			opf.setStime(rs.getString("stime"));
			opf.setPriceSeatR(rs.getInt("priceSeatR"));
			opf.setPriceSeatS(rs.getInt("priceSeatS"));
			opf.setPriceSeatA(rs.getInt("priceSeatA"));
			opf.setId(rs.getString("id"));			

			return opf;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}


	// ���ð��� ����
		public boolean deleteOpenPerformance(String name) {
			connect();
			try {
				String sql = "delete from open_performance where name = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				int check = psmt.executeUpdate();

				if(check == 1) return true;
				else return false;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return false;
		}

	// ���ð��� ����
	public boolean deleteOpenPerformance(int pno) {
		connect();
		try {
			String sql = "delete from open_performance where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}


	// ���ð��� - ���۳�¥ ����
	public boolean updateSdate(String sdate, int pno) {
		connect();
		try {
			String sql = "update open_performance set sdate = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sdate);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}


	// ���ð��� - �����³�¥ ����
	public boolean updateEdate(String edate, int pno) {
		connect();
		try {
			String sql = "update open_performance set edate = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, edate);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ���ð��� - ���۽ð� ����
	public boolean updateStime(String stime, int pno) {
		connect();
		try {
			String sql = "update open_performance set stime = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stime);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ���ð��� - R������ ����
	public boolean updatePriceSeatR(int priceSeatR, int pno) {
		connect();
		try {
			String sql = "update open_performance set priceSeatR = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, priceSeatR);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ���ð��� - S������ ����
	public boolean updatePriceSeatS(int priceSeatS, int pno) {
		connect();
		try {
			String sql = "update open_performance set priceSeatS = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, priceSeatS);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ���ð��� - A������ ����
	public boolean updatePriceSeatA(int priceSeatA, int pno) {
		connect();
		try {
			String sql = "update open_performance set priceSeatA = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, priceSeatA);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	
	//���� ����
	public boolean updateOpened(int pno) {
		connect();
		try {
			String sql = "update open_performance set opened = ? where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 1);
			psmt.setInt(2, pno);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	//���� ���
		public boolean updateOpened2(int pno) {
			connect();
			try {
				String sql = "update open_performance set opened = ? where pno = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, 2);
				psmt.setInt(2, pno);
				int check = psmt.executeUpdate();

				if(check == 1) return true;
				else return false;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return false;
		}





	/* ������ �߰� */
	public boolean StagePerformanceAdd(StagePerformanceDTO stageperfomance) {
		connect();
		try {
			String sql = "insert into performance_stage values(?,?,?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stageperfomance.getPlace());
			psmt.setInt(2, stageperfomance.getSeatOfR());
			psmt.setInt(3, stageperfomance.getSeatOfS());
			psmt.setInt(4, stageperfomance.getSeatOfA());

			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return false;
	}

	// ������ ����
	public boolean deleteStagePerformance(String place) {
		connect();
		try {
			String sql = "delete from performance_stage where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, place);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ������ - ��� ����
	public boolean updatePlace(String place, String originalPlace) {
		connect();
		try {
			String sql = "update performance_stage set place = ? where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, place);
			psmt.setString(2, originalPlace);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ������ - R�� �¼��� ����
	public boolean updateSeatOfR(int seatOfR, String place) {
		connect();
		try {
			String sql = "update performance_stage set seatOfR = ? where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seatOfR);
			psmt.setString(2, place);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}	

	// ������ - S�� �¼��� ����
	public boolean updateSeatOfS(int seatOfS, String place) {
		connect();
		try {
			String sql = "update performance_stage set seatOfS = ? where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seatOfS);
			psmt.setString(2, place);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ������ - A�� �¼��� ����
	public boolean updateSeatOfA(int seatOfA, String place) {
		connect();
		try {
			String sql = "update performance_stage set seatOfA = ? where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seatOfA);
			psmt.setString(2, place);
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	
	public Vector<int[]> reseveSeats(int[] info, String dd) {
		connect();
		try {
			String sql = "select seat from ticketing where pno = ? and tdate = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, info[0]);
			psmt.setString(2, dd);
			rs = psmt.executeQuery();

			int[] r = new int[info[1]];
			int[] s = new int[info[2]];
			int[] a = new int[info[3]];

			char[] rsa = {'R', 'S', 'A'};

			while(rs.next()) {
				for(int i = 0; i < rsa.length; i++) {
					for(int j = 0; j < info[i+1]; j++) {
						if(rs.getString("seat").charAt(0) == rsa[i] 
								&& Integer.parseInt(rs.getString("seat").substring(1, rs.getString("seat").length()))-1 == j
								&& i == 0) {
							r[j] = 1;
						}
						else if(rs.getString("seat").charAt(0) == rsa[i] 
								&& Integer.parseInt(rs.getString("seat").substring(1, rs.getString("seat").length()))-1 == j
								&& i == 1) {
							s[j] = 1;
						}
						else if(rs.getString("seat").charAt(0) == rsa[i] 
								&& Integer.parseInt(rs.getString("seat").substring(1, rs.getString("seat").length()))-1 == j
								&& i == 2) {
							a[j] = 1;
						}
					}
				}
			}
			
			Vector<int[]> reserve = new Vector<int[]>();
			
			reserve.add(r);
			reserve.add(s);
			reserve.add(a);
			
			return reserve;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	
	public int printSeat(int[] info) {
		connect();
		try {
			String sql = "select seat from ticketing where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, info[0]);
			rs = psmt.executeQuery();

			int[] r = new int[info[1]];
			int[] s = new int[info[2]];
			int[] a = new int[info[3]];

			int maxLength = 0;
			if(r.length > s.length)
				maxLength = r.length;
			else maxLength = s.length;
			if(maxLength < a.length)
				maxLength = a.length;

			char[] rsa = {'R', 'S', 'A'};

			while(rs.next()) {
				for(int i = 0; i < rsa.length; i++) {
					for(int j = 0; j < info[i+1]; j++) {
						if(rs.getString("seat").charAt(0) == rsa[i] 
								&& Integer.parseInt(rs.getString("seat").substring(1, rs.getString("seat").length()))-1 == j
								&& i == 0) {
							r[j] = 1;
						}
						else if(rs.getString("seat").charAt(0) == rsa[i] 
								&& Integer.parseInt(rs.getString("seat").substring(1, rs.getString("seat").length()))-1 == j
								&& i == 1) {
							s[j] = 1;
						}
						else if(rs.getString("seat").charAt(0) == rsa[i] 
								&& Integer.parseInt(rs.getString("seat").substring(1, rs.getString("seat").length()))-1 == j
								&& i == 2) {
							a[j] = 1;
						}
					}
				}
			}

			System.out.println("***************�¼� ***************");
			System.out.println("*        ���ʺ���   1�� �Դϴ�\t\t*");
			for(int i = 0; i < rsa.length; i++) {
				if(i == 0) {
					System.out.print("* R �� ");
					for(int k = 0; k < maxLength-r.length; k++)
						System.out.print("  ");
				}
				else if(i== 1) {
					System.out.print("* S �� ");
					for(int k = 0; k < maxLength-s.length; k++)
						System.out.print("  ");
				}
				else if(i ==2) {
					System.out.print("* A �� ");
					for(int k = 0; k < maxLength-a.length; k++)
						System.out.print("  ");
				}



				for(int j = 0; j < info[i+1]; j++) {
					if(i == 0 && r[j] == 1) {
						System.out.print("�� ");
					}
					else if (i == 1 && s[j] == 1) {
						System.out.print("�� ");
					}
					else if (i == 2 && a[j] == 1) {
						System.out.print("�� ");
					}
					else
						System.out.print("�� ");
				}
				System.out.println("");
			}
			return info[0];
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return 0;
	}




	///////////////////////////���
	// ���� ���� ���(�߰�)
	public boolean openPerformanceAdd(OpenPerformanceDTO openperfomance) {
		connect();
		try {
			String sql = "insert into open_performance values(0,?,?,?,?,?,?,?,?,?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, openperfomance.getName());
			psmt.setString(2, openperfomance.getPlace());
			psmt.setString(3, openperfomance.getSdate());
			psmt.setString(4, openperfomance.getEdate());
			psmt.setString(5, openperfomance.getStime());
			psmt.setInt(6, openperfomance.getPriceSeatR());
			psmt.setInt(7, openperfomance.getPriceSeatS());
			psmt.setInt(8, openperfomance.getPriceSeatA());
			psmt.setString(9, openperfomance.getId());
			psmt.setInt(10, openperfomance.getOpened());
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return false;
	}

	// ��ü ������ ��ȸ
	public Vector<StagePerformanceDTO> totalInquiryStagePerformance() {
		connect();
		Vector<StagePerformanceDTO> spfList = new Vector<StagePerformanceDTO>();
		StagePerformanceDTO spf;
		try {

			String sql = "select * from performance_stage";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				spf = new StagePerformanceDTO();
				spf.setPlace(rs.getString("place"));
				spf.setSeatOfR(rs.getInt("seatOfR"));
				spf.setSeatOfS(rs.getInt("seatOfS"));
				spf.setSeatOfA(rs.getInt("seatOfA"));
				spfList.addElement(spf);
			}
			return spfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	//id�� �������� ��� ���� ��ȸ
	public Vector<PerformanceDTO> adminInquiryPerformanceById(String id) {	
		connect();
		Vector<PerformanceDTO> pfList = new Vector<PerformanceDTO>();
		PerformanceDTO pf;
		try {
			String sql = "select * from performance where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while(rs.next()) {
				pf = new PerformanceDTO(); 
				pf.setName(rs.getString("name"));
				pf.setType(rs.getString("type"));
				pf.setTime(rs.getInt("time"));
				pf.setId(rs.getString("id"));	
				pfList.addElement(pf);
			}
			return pfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	//id�� ���ð��� ��ȸ
	public Vector<OpenPerformanceDTO> adminInquiryOpenPerformanceById(String id) {	
		connect();
		Vector<OpenPerformanceDTO> opfList = new Vector<OpenPerformanceDTO>();
		OpenPerformanceDTO opf;
		try {
			String sql = "select * from open_performance where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while(rs.next()) {
				opf = new OpenPerformanceDTO();
				opf.setPno(rs.getInt("pno"));
				opf.setName(rs.getString("name"));
				opf.setPlace(rs.getString("place"));
				opf.setSdate(rs.getString("sdate"));
				opf.setEdate(rs.getString("edate"));
				opf.setStime(rs.getString("stime"));
				opf.setPriceSeatR(rs.getInt("priceSeatR"));
				opf.setPriceSeatS(rs.getInt("priceSeatS"));
				opf.setPriceSeatA(rs.getInt("priceSeatA"));
				opf.setId(rs.getString("id"));	
				opf.setOpened(rs.getInt("opened"));	

				opfList.addElement(opf);
			}
			return opfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	// ���� �̸� �ߺ� üũ
	public boolean checkName(String name) {	//name�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from performance where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			return rs.next();	//�ߺ��� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;//�ߺ����� ���� ��� false��ȯ
	}
	// ���� ���� ���� ���� üũ
	public boolean checkNum(int num) {	//pno�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from open_performance where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();

			return rs.next();	//�ߺ��� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;//�ߺ����� ���� ��� false��ȯ
	}
	// ���� ���� ���� ���� üũ
	public boolean checkPName(String name) {	//pno�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from open_performance where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			return rs.next();	//�ߺ��� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;//�ߺ����� ���� ��� false��ȯ
	}

	// ���� �ȵ� ���� �߰�
	public boolean performanceAdd(PerformanceDTO performance) {
		connect();
		try {
			String sql = "insert into performance values(?,?,?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, performance.getName());
			psmt.setString(2, performance.getType());
			psmt.setInt(3, performance.getTime());
			psmt.setString(4, performance.getId());
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return false;
	}
	public int[] getSeats(int pno) {
		connect();
		int[] info = new int[4];
		StringBuffer sql = new StringBuffer("select pno,seatOfR,seatOfS,seatOfA from open_performance join performance_stage");
		sql.append(" on open_performance.place = performance_stage.place");
		sql.append(" where pno = ?");
		try {
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1,pno);

			rs = psmt.executeQuery();
			rs.next();
			info[0] = rs.getInt("pno");
			info[1] = rs.getInt("seatOfR");
			info[2] = rs.getInt("seatOfS");
			info[3] = rs.getInt("seatOfA");
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	// pno�� ���� ��ȸ
	public OpenPerformanceDTO memberInquiryOpenPerformance(int pno) {
		connect();
		OpenPerformanceDTO opf = new OpenPerformanceDTO();
		try {
			String sql = "select * from open_performance where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pno);
			rs = psmt.executeQuery();

			rs.next();
			opf.setPno(rs.getInt("pno"));
			opf.setName(rs.getString("name"));
			opf.setPlace(rs.getString("place"));
			opf.setSdate(rs.getString("sdate"));
			opf.setEdate(rs.getString("edate"));
			opf.setStime(rs.getString("stime"));
			opf.setPriceSeatR(rs.getInt("priceSeatR"));
			opf.setPriceSeatS(rs.getInt("priceSeatS"));
			opf.setPriceSeatA(rs.getInt("priceSeatA"));
			opf.setId(rs.getString("id"));
			opf.setOpened(rs.getInt("opened"));
			
			return opf;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	//������ ������ȸ
	public Vector<Integer> adminInquiryPno(String id) { // id�� ���� ��ȣ�� ��ȸ
		connect();
		OpenPerformanceDTO opf;
		Vector<Integer> pnoList = new Vector<Integer>();
		try {
			String sql = "select pno from open_performance where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				opf = new OpenPerformanceDTO();
				pnoList.addElement(rs.getInt("pno"));
			}

			return pnoList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if (rs != null)rs.close();} catch (Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	public boolean openPerformPublish(int pno) {
		connect();
		try {
			String sql = "update open_performance set opened = 1 where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,pno);

			if(psmt.executeUpdate() ==1) return true;
			else return false;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;

	}

	public Vector<OpenPerformanceDTO> totalInquiryOpenPerformanceOpened() {
		connect();
		Vector<OpenPerformanceDTO> opfList = new Vector<OpenPerformanceDTO>();
		OpenPerformanceDTO opf;
		try {

			String sql = "select * from open_performance where opened = 1";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				opf = new OpenPerformanceDTO();
				opf.setPno(rs.getInt("pno"));
				opf.setName(rs.getString("name"));
				opf.setPlace(rs.getString("place"));
				opf.setSdate(rs.getString("sdate"));
				opf.setEdate(rs.getString("edate"));
				opf.setStime(rs.getString("stime"));
				opf.setPriceSeatR(rs.getInt("priceSeatR"));
				opf.setPriceSeatS(rs.getInt("priceSeatS"));
				opf.setPriceSeatA(rs.getInt("priceSeatA"));
				opf.setId(rs.getString("id"));
				opf.setOpened(rs.getInt("opened"));

				opfList.addElement(opf);
			}
			return opfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}


	// ��Ʈ����Ʈ�� Ÿ��Ʋ�� ������
	public Vector<String> getMemberTitleById(String id) {
		Vector<String> memberTitles = new Vector<String>();
		connect();
		try {
			String sql = "select * from open_performance where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			ResultSetMetaData  rsm = rs.getMetaData();        

			int cnt = rsm.getColumnCount();

			while(rs.next()) { 
				for (int i=2; i<=cnt-1; i++) {
					String title = rsm.getColumnLabel(i);   // ��Ʈ����Ʈ�� Ÿ��Ʋ�� ������
					Object obj = rs.getObject(i);
					memberTitles.addElement(title);
				} 
			}

		} catch (SQLException e) {
			System.out.println(" !! PerformanceDAO.getMemberTitle() error!");
			e.printStackTrace();

		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return memberTitles;
	}

	//��Ʈ����Ʈ ���� ���� �޾Ƽ� ����1 - String
	public boolean updateTitleById1(int id, String title, String content) { 
		connect();
		try {      
			String sql = "update open_performance set "+ title + " = "
					+ "'"+content+"'" + " where pno = " + id;
			stmt = conn.createStatement();

			int check = stmt.executeUpdate(sql);

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	//��Ʈ����Ʈ ���� ���� �޾Ƽ� ����2 - int
	public boolean updateTitleById2(int id, String title, String content) { 
		connect();
		try {      
			String sql = "update open_performance set "+ title + " = "
					+content + " where pno = " + id;
			stmt = conn.createStatement();

			int check = stmt.executeUpdate(sql);

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	//id�� ���ð��� ��ȸ
	public Vector<OpenPerformanceDTO> adminInquiryOpenPerformanceByOpened(String id) {	
		connect();
		Vector<OpenPerformanceDTO> opfList = new Vector<OpenPerformanceDTO>();
		OpenPerformanceDTO opf;
		try {
			String sql = "select * from open_performance where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while(rs.next()) {
				opf = new OpenPerformanceDTO();
				opf.setPno(rs.getInt("pno"));
				opf.setName(rs.getString("name"));
				//opf.setPlace(rs.getString("place"));
				opf.setSdate(rs.getString("sdate"));
				//opf.setEdate(rs.getString("edate"));
				//opf.setStime(rs.getString("stime"));
				//opf.setPriceSeatR(rs.getInt("priceSeatR"));
				//opf.setPriceSeatS(rs.getInt("priceSeatS"));
				//opf.setPriceSeatA(rs.getInt("priceSeatA"));
				opf.setId(rs.getString("id"));			

				opfList.addElement(opf);
			}
			return opfList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public int priceOfSeatR(int pno) {
		connect();
		try {
			String sql = "select priceSeatR from open_performance where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pno);

			rs = psmt.executeQuery();
			rs.next();
			return rs.getInt("priceSeatR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return 0;
	}

	public int priceOfSeatS(int pno) {
		connect();
		try {
			String sql = "select priceSeatS from open_performance where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pno);

			rs = psmt.executeQuery();
			rs.next();
			return rs.getInt("priceSeatS");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return 0;
	}

	public int priceOfSeatA(int pno) {
		connect();
		try {
			String sql = "select priceSeatA from open_performance where pno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pno);

			rs = psmt.executeQuery();
			rs.next();
			return rs.getInt("priceSeatA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return 0;
	}
	
	//Opened�� ���ð��� ��ȸ(1)
		public Vector<OpenPerformanceDTO> adminInquiryOpenPerformanceByOpened() {	
			connect();
			Vector<OpenPerformanceDTO> opfList = new Vector<OpenPerformanceDTO>();
			OpenPerformanceDTO opf;
			try {
				String sql = "select * from open_performance where opened = 1";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();

				while(rs.next()) {
					opf = new OpenPerformanceDTO();
					opf.setPno(rs.getInt("pno"));
					opf.setName(rs.getString("name"));
					opf.setPlace(rs.getString("place"));
					opf.setSdate(rs.getString("sdate"));
					opf.setEdate(rs.getString("edate"));
					opf.setStime(rs.getString("stime"));
					opf.setPriceSeatR(rs.getInt("priceSeatR"));
					opf.setPriceSeatS(rs.getInt("priceSeatS"));
					opf.setPriceSeatA(rs.getInt("priceSeatA"));
					opf.setId(rs.getString("id"));	
					opf.setOpened(rs.getInt("opened"));	

					opfList.addElement(opf);
				}
				return opfList;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(rs!=null) rs.close();} catch(Exception e) {}
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return null;
		}
		
		//Opened�� ���ð��� ��ȸ(2)
		public Vector<OpenPerformanceDTO> adminInquiryOpenPerformanceByClosed() {	
			connect();
			Vector<OpenPerformanceDTO> opfList = new Vector<OpenPerformanceDTO>();
			OpenPerformanceDTO opf;
			try {
				String sql = "select * from open_performance where opened = 0";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();

				while(rs.next()) {
					opf = new OpenPerformanceDTO();
					opf.setPno(rs.getInt("pno"));
					opf.setName(rs.getString("name"));
					opf.setPlace(rs.getString("place"));
					opf.setSdate(rs.getString("sdate"));
					opf.setEdate(rs.getString("edate"));
					opf.setStime(rs.getString("stime"));
					opf.setPriceSeatR(rs.getInt("priceSeatR"));
					opf.setPriceSeatS(rs.getInt("priceSeatS"));
					opf.setPriceSeatA(rs.getInt("priceSeatA"));
					opf.setId(rs.getString("id"));	
					opf.setOpened(rs.getInt("opened"));	

					opfList.addElement(opf);
				}
				return opfList;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(rs!=null) rs.close();} catch(Exception e) {}
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return null;
		}
}
