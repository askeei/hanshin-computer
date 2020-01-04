package DAO;

import java.sql.*;
import java.util.Vector;

import DTO.MemberDTO;
import main.*;


public class MemberDAO {
	//TODO: 이게 만약안되면 =null 해주기!!!
	private DB getCon;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement psmt;
	private ResultSet rs;	//안돌아가면 null

	private void connect() {
		this.conn = this.getCon.loadConnection();
	}

	public boolean memberRegist(MemberDTO member) {
		connect();
		try {
			String sql = "insert into member values(?,?,?,?,?,?);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getSex());
			psmt.setString(5, member.getPhone());
			psmt.setInt(6, member.getType());
			int check = psmt.executeUpdate();

			if(check == 1) return true;
			else return false;
		} catch (SQLException e) {
			System.out.print("* 회원가입 오류! ");
			e.printStackTrace();
		} finally {
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return false;
	}

	public boolean checkID(String id) {	//회원가입시 id의 중복체크
		connect();
		try {
			String sql = "select * from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			return rs.next(); //중복일 경우 true반환

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	public boolean checkID2(String id) {	//수정, 삭제시 id의 중복체크
		connect();
		try {
			String sql = "select * from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if(!rs.next()) return true; //존재하지 않을 경우 true반환
			else return false;	//존재 할경우 false반환

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return false;
	}

	public boolean checkPasswd(MemberDTO member, String passwd) {	//비밀번호 확인 체크
		if(passwd.compareTo(member.getPw()) != 0) {
			System.out.println(" ※ 비밀번호가 서로 다릅니다! ");
			return true;	//같지 않을 경우 true
		}
		else return false;	//같을 경우 false
	}

	public int login(String id,String pw) {
		connect();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select type from member where id = '"
					+ id + "' and pw = '" + pw + "';");

			if(!rs.next()) return -1;	//id,pw 틀린경우
			return rs.getInt("type");	//관리자,회원(1,0)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return 0;
	}

	public String selectMember(String id) {	//update문 사용 시, 기본키로 설정된 id를 기준으로 update하기 위해 원하는 member의 id를 반납
		connect();
		try {
			String sql = "select id from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			return rs.getString("id");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}

		return null;
	}

	public boolean updateID(String id, String originalID) {
		connect();
		try {
			String sql = "update member set id = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, originalID);
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
	public boolean updateInfo(String id, String pw, String sex, String phone) {
		connect();
		try {
			String sql = "update member set pw = ?, sex = ?, phone = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, sex);
			psmt.setString(3, phone);
			psmt.setString(4, id);
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
	

	public boolean updatePW(String pw, String id) {
		connect();
		try {
			String sql = "update member set pw = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, id);
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

	public boolean updateName(String name, String id) {
		connect();
		try {
			String sql = "update member set name = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, id);
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

	public boolean updateAddr(String address, String id) {
		connect();
		try {
			String sql = "update member set address = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, address);
			psmt.setString(2, id);
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

	public boolean updateSex(String sex, String id) {
		connect();
		try {
			String sql = "update member set sex = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sex);
			psmt.setString(2, id);
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

	public boolean updatePhone(String phone, String id) {
		connect();
		try {
			String sql = "update member set phone = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			psmt.setString(2, id);
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

	public boolean adminRegistration(MemberDTO member) {	//관리자 등록
		connect();
		try {
			String sql = "insert into member values(?,?,?,?,?,?,1);";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getSex());
			psmt.setString(5, member.getPhone());
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

	public boolean adminDrop(MemberDTO member) {	//관리자 삭제
		try {
			String sql = "delete from member where name = ? and type = 1";
			psmt.setString(1, member.getName());
			psmt = conn.prepareStatement(sql);
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

	public MemberDTO searchID(String id) {	//id별 검색
		connect();
		MemberDTO member= new MemberDTO();
		try {
			String sql = "select * from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			rs.next();
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setName(rs.getString("name"));
			member.setSex(rs.getString("sex"));
			member.setPhone(rs.getString("phone"));
			member.setType(rs.getInt("type"));
			return member;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<MemberDTO> searchName(String name) {	//name별 검색(여러개의 데이터가 출력될 수 있으므로 memberList로)
		connect();

		MemberDTO member= new MemberDTO();
		Vector<MemberDTO> memberList = new Vector<MemberDTO>();
		try {
			String sql = "select * from member where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while(rs.next()) {
				member.setId(rs.getString("id"))
				.setPw(rs.getString("pw"))
				.setName(rs.getString("name"))
				.setSex(rs.getString("sex"))
				.setPhone(rs.getString("phone"))
				.setType(rs.getInt("type"));
				memberList.add(member);
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<MemberDTO> searchAddr(String address) {	//address별 검색
		connect();
		MemberDTO member= new MemberDTO();
		Vector<MemberDTO> memberList = new Vector<MemberDTO>();
		try {
			String sql = "select * from member where address = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, address);
			rs = psmt.executeQuery();

			while(rs.next()) {
				member.setId(rs.getString("id"))
				.setPw(rs.getString("pw"))
				.setName(rs.getString("name"))
				.setSex(rs.getString("sex"))
				.setPhone(rs.getString("phone"))
				.setType(rs.getInt("type"));
				memberList.add(member);
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<MemberDTO> searchSex(String sex) {	//sex별 검색
		connect();
		MemberDTO member= new MemberDTO();
		Vector<MemberDTO> memberList = new Vector<MemberDTO>();
		try {
			String sql = "select * from member where sex = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sex);
			rs = psmt.executeQuery();

			while(rs.next()) {
				member.setId(rs.getString("id"))
				.setPw(rs.getString("pw"))
				.setName(rs.getString("name"))
				.setSex(rs.getString("sex"))
				.setPhone(rs.getString("phone"))
				.setType(rs.getInt("type"));
				memberList.add(member);
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<MemberDTO> searchPhone(String phone) {	//phone별 검색
		connect();
		MemberDTO member= new MemberDTO();
		Vector<MemberDTO> memberList = new Vector<MemberDTO>();
		try {
			String sql = "select * from member where phone = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phone);
			rs = psmt.executeQuery();

			while(rs.next()) {
				member.setId(rs.getString("id"))
				.setPw(rs.getString("pw"))
				.setName(rs.getString("name"))
				.setSex(rs.getString("sex"))
				.setPhone(rs.getString("phone"))
				.setType(rs.getInt("type"));
				memberList.add(member);
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<MemberDTO> searchType(int type) {	//type별 검색 관리자/회원
		connect();
		MemberDTO member;
		Vector<MemberDTO> memberList = new Vector<MemberDTO>();
		try {
			String sql = "select * from member where type = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, type);
			rs = psmt.executeQuery();

			while(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("id"))
				.setPw(rs.getString("pw"))
				.setName(rs.getString("name"))
				.setSex(rs.getString("sex"))
				.setPhone(rs.getString("phone"))
				.setType(rs.getInt("type"));
				memberList.addElement(member);
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<MemberDTO> searchWhole() {	//전체 검색
		connect();
		MemberDTO member= new MemberDTO();
		Vector<MemberDTO> memberList = new Vector<MemberDTO>();
		try {
			String sql = "select * from member";

			if(stmt.execute(sql) == true) {
				rs = stmt.getResultSet();
				member.setId(rs.getString("id"))
				.setPw(rs.getString("pw"))
				.setName(rs.getString("name"))
				.setSex(rs.getString("sex"))
				.setPhone(rs.getString("phone"))
				.setType(rs.getInt("type"));
				memberList.add(member);

				while(stmt.getMoreResults() == true) {
					rs = stmt.getResultSet();
					member.setId(rs.getString("id"))
					.setPw(rs.getString("pw"))
					.setName(rs.getString("name"))
					.setSex(rs.getString("sex"))
					.setPhone(rs.getString("phone"))
					.setType(rs.getInt("type"));
					memberList.add(member);
				}
			}
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return null;
	}

	public Vector<String> getMemberTitleById(String id) {
		Vector<String> memberTitles = new Vector<String>();
		connect();
		try {
			String sql = "select * from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			ResultSetMetaData  rsm = rs.getMetaData();        

			int cnt = rsm.getColumnCount();

			while(rs.next()) { 
				for (int i=2; i<=cnt-1; i++) {
					String title = rsm.getColumnLabel(i);   // 애트리뷰트의 타이틀을 가져옴
					Object obj = rs.getObject(i);
					memberTitles.addElement(title);
				} 
			}

		} catch (SQLException e) {
			System.out.println(" !! MemberDAO.getMemberTitle() error!");
			e.printStackTrace();

		} finally {
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(psmt!=null) psmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
		return memberTitles;
	}

	public boolean updateTitleById(String id, String title, String content) { //애트리뷰트 제목 값을 받아서 수정
		connect();
		try {		
			String sql = "update member set "+ title + " = "
					+ "'"+content+"'" + " where id = '" + id + "'";
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

	public boolean deleteById(String id) {	//관리자 삭제
		connect();
		try {
			String sql = "delete from member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
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
	
	public Vector<MemberDTO> inquiryWholeMember() {   //전체 검색
	      connect();
	      Vector<MemberDTO> memberList = new Vector<MemberDTO>();
	      MemberDTO member;
	      try {
	         String sql = "select * from member where type= 1 or type= 0";
	         psmt = conn.prepareStatement(sql);
	         rs = psmt.executeQuery();

	         while(rs.next()) {
	            member = new MemberDTO();
	            member.setId(rs.getString("id"));
	            member.setName(rs.getString("name"));
	            member.setSex(rs.getString("sex"));
	            member.setPhone(rs.getString("phone"));
	            member.setType(rs.getInt("type"));
	            memberList.addElement(member);
	         }
	         
	         return memberList;
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


