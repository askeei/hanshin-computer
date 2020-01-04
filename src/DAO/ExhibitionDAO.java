package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DTO.ExhibitionDTO;
import DTO.OpenExhibitionDTO;
import DTO.OpenPerformanceDTO;
import DTO.PerformanceDTO;
import DTO.StageExhibitionDTO;
import main.DB;


public class ExhibitionDAO {
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
	public Vector<ExhibitionDTO> totalInquiryExhibition() {
		connect();
		Vector<ExhibitionDTO> ebList = new Vector<ExhibitionDTO>();
		ExhibitionDTO eb;
		try {

			String sql = "select * from exhibition";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();



			while(rs.next()) {
				eb = new ExhibitionDTO();
				eb.setName(rs.getString("name"));
				eb.setGenre(rs.getString("genre"));
				eb.setSponsor(rs.getString("sponsor"));
				ebList.addElement(eb);
			}
			return ebList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	// ������ȸ
	public ExhibitionDTO inquiryExhibition(String name) {
		connect();
		ExhibitionDTO pf = new ExhibitionDTO();
		try {
			String sql = "select * from exhibition where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			rs.next();
			pf.setName(rs.getString("name"));
			pf.setGenre(rs.getString("genre"));
			pf.setSponsor(rs.getString("sponsor"));

			return pf;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}



	// ���� - �̸� ����
	public boolean updateName(String name, String originalName) {
		connect();
		try {
			String sql = "update exhibition set name = ? where name = ?";
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



	// ���� - �帣 ����
	public boolean updateGenre(String genre, String name) {
		connect();
		try {
			String sql = "update exhibition set genre = ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, genre);
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

	// ���� - ������ ����
	public boolean updateSponsor(String sponsor, String name) {
		connect();
		try {
			String sql = "update exhibition set sponsor = ? where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sponsor);
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

	// ���û���
	public boolean deleteExhibition(String name) {
		connect();
		try {
			String sql = "delete from exhibition where name = ?";
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


	// ��ü �������� ��ȸ
	public Vector<OpenExhibitionDTO> totalInquiryOpenExhibition() {
		connect();
		Vector<OpenExhibitionDTO> oebList = new Vector<OpenExhibitionDTO>();
		OpenExhibitionDTO oeb;
		try {

			String sql = "select * from open_exhibition where opened = 1";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				oeb = new OpenExhibitionDTO();
				oeb.setEno(rs.getInt("eno"));
				oeb.setName(rs.getString("name"));
				oeb.setPlace(rs.getString("place"));
				oeb.setSdate(rs.getString("sdate"));
				oeb.setEdate(rs.getString("edate"));
				oeb.setPrice(rs.getInt("price"));
				oeb.setId(rs.getString("id"));
				oeb.setOpened(rs.getInt("opened"));
				oebList.addElement(oeb);
			}
			return oebList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	// ������ - ����������ȸ
	public OpenExhibitionDTO inquiryOpenExhibition(String admin) {
		connect();
		OpenExhibitionDTO oeb = new OpenExhibitionDTO();
		try {
			String sql = "select * from open_exhibition where admin = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, admin);
			rs = psmt.executeQuery();

			rs.next();

			oeb.setEno(rs.getInt("eno"));
			oeb.setSdate(rs.getString("sdate"));
			oeb.setEdate(rs.getString("edate"));
			oeb.setPrice(rs.getInt("price"));
			oeb.setId(rs.getString("id"));

			return oeb;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}


	/* �������� �߰� */
	public boolean openExhibitionAdd(OpenExhibitionDTO openexhibition) {
		connect();
		try {
			String sql = "insert into open_exhibition values(0,?,?,?,?,?,?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, openexhibition.getName());
			psmt.setString(2, openexhibition.getPlace());
			psmt.setString(3, openexhibition.getSdate());
			psmt.setString(4, openexhibition.getEdate());
			psmt.setInt(5, openexhibition.getPrice());
			psmt.setString(6, openexhibition.getId());
			psmt.setInt(7, openexhibition.getOpened());
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

	// �������� ����
	public boolean deleteOpenExhibition(int eno) {
		connect();
		try {
			String sql = "delete from open_exhibition where eno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno);
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

	// �������� - ���۳�¥ ����
	public boolean updateSdate(String sdate, int eno) {
		connect();
		try {
			String sql = "update open_exhibition set sdate = ? where eno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sdate);
			psmt.setInt(2, eno);
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

	// �������� - �����³�¥ ����
	public boolean updateEdate(String edate, int eno) {
		connect();
		try {
			String sql = "update open_exhibition set edate = ? where eno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, edate);
			psmt.setInt(2, eno);
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

	// �������� - ���� ����
	public boolean updatePrice(int price, int eno) {
		connect();
		try {
			String sql = "update open_exhibition set price = ? where eno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setInt(2, eno);
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
	public boolean StageExhibitionAdd(StageExhibitionDTO stageexhibition) {
		connect();
		try {
			String sql = "insert into exhibition_stage values(?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stageexhibition.getPlace());
			psmt.setString(2, stageexhibition.getClosure());
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
	public boolean deleteStageExhibition(String place) {
		connect();
		try {
			String sql = "delete from exhibition_stage where place = ?";
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
			String sql = "update exhibition_stage set place = ? where place = ?";
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

	// ������ - ����� ����
	public boolean updateClosure(String closure, String place) {
		connect();
		try {
			String sql = "update exhibition_stage set closure = ? where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, closure);
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

	// ������ - ��� �ߺ� üũ
	public boolean checkPlace(String place) {	//place�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from exhibition_stage where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, place);
			rs = psmt.executeQuery();

			return rs.next();	//�ߺ��� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	// ������2 - ��� �ߺ� üũ
	public boolean checkPlace2(String place) {	//id�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from exhibition_stage where place = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, place);
			rs = psmt.executeQuery();

			if(!rs.next()) return true;	//�ߺ��� ��� true��ȯ

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}


	////////////////////////���
	// ���� - �̸� �ߺ� üũ
	public boolean checkName(String name) {	//id�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from exhibition where name = ?";
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
		return false;
	}
	// ���� - �̸� �ߺ� üũ
	public boolean checkeNum(int num) {	//id�� �ߺ�üũ
		connect();
		try {
			String sql = "select * from exhibition where eno = ?";
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
		return false;
	}


	// ��ü ������ ��ȸ
	public Vector<StageExhibitionDTO> totalInquirStageExhibition() {
		connect();
		Vector<StageExhibitionDTO> sebList = new Vector<StageExhibitionDTO>();
		StageExhibitionDTO seb;
		try {

			String sql = "select * from exhibition_stage";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while(rs.next()) {
				seb = new StageExhibitionDTO();
				seb.setPlace(rs.getString("place"));
				seb.setClosure(rs.getString("closure"));
				sebList.addElement(seb);
			}
			return sebList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();}catch(Exception e){}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	// ���� �߰�
	public boolean exhibitionAdd(ExhibitionDTO perfomance) {
		connect();
		try {
			String sql = "insert into exhibition values(?,?,?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, perfomance.getName());
			psmt.setString(2, perfomance.getGenre());
			psmt.setString(3, perfomance.getSponsor());
			psmt.setString(4, perfomance.getId());
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

	//id�� �������� ��� ���� ��ȸ
	public Vector<ExhibitionDTO> adminInquiryExhibitionById(String id) {	
		connect();
		Vector<ExhibitionDTO> ebList = new Vector<ExhibitionDTO>();
		ExhibitionDTO eb;
		try {
			String sql = "select * from exhibition where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while(rs.next()) {
				eb = new ExhibitionDTO(); 
				eb.setName(rs.getString("name"));
				eb.setGenre(rs.getString("genre"));
				eb.setSponsor(rs.getString("sponsor"));
				eb.setId(rs.getString("id"));	
				ebList.addElement(eb);
			}
			return ebList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}
	//id�� �������� ��� ���� ���� ��ȸ
		public Vector<OpenExhibitionDTO> adminInquiryOpenExhibitionById(String id) {	
			connect();
			Vector<OpenExhibitionDTO> ebList = new Vector<OpenExhibitionDTO>();
			OpenExhibitionDTO eb;
			try {
				String sql = "select * from open_exhibition where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();

				while(rs.next()) {
					eb = new OpenExhibitionDTO(); 
					eb.setEno(rs.getInt("eno"));
					eb.setName(rs.getString("name"));
					eb.setPlace(rs.getString("place"));
					eb.setSdate(rs.getString("sdate"));
					eb.setEdate(rs.getString("edate"));
					eb.setPrice(rs.getInt("price"));
					eb.setId(rs.getString("id"));
					ebList.addElement(eb);
				}
				return ebList;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(rs!=null) rs.close();} catch(Exception e) {}
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return null;
		}

	public boolean openExhibitionPublish(int eno) {
		connect();
		String sql = "update open_exhibition set opened = 1 where eno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno);
			if (psmt.executeUpdate() == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}
	
	// ��Ʈ����Ʈ�� Ÿ��Ʋ�� ������
	   public Vector<String> getMemberTitleById(String id) {
	      Vector<String> memberTitles = new Vector<String>();
	      connect();
	      try {
	         String sql = "select * from open_exhibition where id = ?";
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
	         System.out.println(" !! ExhibitionDAO.getMemberTitle() error!");
	         e.printStackTrace();

	      } finally {
	         try {if(rs!=null) rs.close();} catch(Exception e) {}
	         try {if(psmt!=null) psmt.close();} catch(Exception e) {}
	         try {if(conn!=null) conn.close();} catch(Exception e) {}
	      }
	      return memberTitles;
	   }

	   
	   
	// ���� ���� - ��ȣ �ߺ� üũ
	   public boolean checkoeNum(int num) {   //id�� �ߺ�üũ
	      connect();
	      try {
	         String sql = "select * from open_exhibition where eno = ?";
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, num);
	         rs = psmt.executeQuery();   

	         return rs.next();   //�ߺ��� ��� true��ȯ

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {if(rs!=null) rs.close();} catch(Exception e) {}
	         try {if(psmt!=null) psmt.close();} catch(Exception e) {}
	         try {if(conn!=null) conn.close();} catch(Exception e) {}
	      }
	      return false;
	   }
	   
	 //��Ʈ����Ʈ ���� ���� �޾Ƽ� ����1 - String
	   public boolean updateTitleById1(int id, String title, String content) { 
	      connect();
	      try {      
	         String sql = "update open_exhibition set "+ title + " = "
	               + "'"+content+"'" + " where eno = " + id;
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
	         String sql = "update open_exhibition set "+ title + " = "
	               +content + " where eno = " + id;
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
	   
	 //Opened�� �������� ��ȸ(1)
	 		public Vector<OpenExhibitionDTO> adminInquiryOpenExhibitionByOpened() {	
	 			connect();
	 			Vector<OpenExhibitionDTO> oexList = new Vector<OpenExhibitionDTO>();
	 			OpenExhibitionDTO oex;
	 			try {
	 				String sql = "select * from open_exhibition where opened = 1";
	 				psmt = conn.prepareStatement(sql);
	 				rs = psmt.executeQuery();

	 				while(rs.next()) {
	 					oex = new OpenExhibitionDTO();
	 					oex.setEno(rs.getInt("eno"));
	 					oex.setName(rs.getString("name"));
	 					oex.setPlace(rs.getString("place"));
	 					oex.setSdate(rs.getString("sdate"));
	 					oex.setEdate(rs.getString("edate"));
	 					oex.setPrice(rs.getInt("price"));
	 					oex.setId(rs.getString("id"));	
	 					oex.setOpened(rs.getInt("opened"));	

	 					oexList.addElement(oex);
	 				}
	 				return oexList;

	 			} catch (SQLException e) {
	 				e.printStackTrace();
	 			} finally {
	 				try {if(rs!=null) rs.close();} catch(Exception e) {}
	 				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
	 				try {if(conn!=null) conn.close();} catch(Exception e) {}
	 			}
	 			return null;
	 		}
	 		//Opened�� �������� ��ȸ(1)
	 		public Vector<OpenExhibitionDTO> adminInquiryOpenExhibitionByClosed() {	
	 			connect();
	 			Vector<OpenExhibitionDTO> oexList = new Vector<OpenExhibitionDTO>();
	 			OpenExhibitionDTO oex;
	 			try {
	 				String sql = "select * from open_exhibition where opened = 0";
	 				psmt = conn.prepareStatement(sql);
	 				rs = psmt.executeQuery();

	 				while(rs.next()) {
	 					oex = new OpenExhibitionDTO();
	 					oex.setEno(rs.getInt("eno"));
	 					oex.setName(rs.getString("name"));
	 					oex.setPlace(rs.getString("place"));
	 					oex.setSdate(rs.getString("sdate"));
	 					oex.setEdate(rs.getString("edate"));
	 					oex.setPrice(rs.getInt("price"));
	 					oex.setId(rs.getString("id"));	
	 					oex.setOpened(rs.getInt("opened"));	

	 					oexList.addElement(oex);
	 				}
	 				return oexList;

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
