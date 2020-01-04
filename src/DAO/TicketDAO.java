package DAO;
import java.sql.*;
import java.util.Vector;

import DTO.TicketDTO;
import main.DB;
public class TicketDAO {
	//TODO: 이게 만약안되면 =null 해주기!!!
		private DB getCon;
		private Connection conn;
		//private Statement stmt;
		private PreparedStatement psmt;
		private ResultSet rs;	//안돌아가면 null
		
		private void connect() {
			this.conn = this.getCon.loadConnection();
		}
					
		// 예매 정보 등록 메소드
		public boolean ticketingRegist(TicketDTO ticketing) {
			connect();
			
			try {
				String sql = "insert into ticketing values(0,?,?,?,?);";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, ticketing.getId());
				psmt.setInt(2,ticketing.getPno());
				psmt.setString(3,ticketing.getSeat());
				psmt.setString(4,ticketing.getTdate());
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

		// 예매 정보 조회 메소드
		public Vector<TicketDTO> selectTicket(String id) {	
			connect();
			TicketDTO ticket;
			Vector<TicketDTO> tkList = new Vector<TicketDTO>();
			try {
				String sql = "select * from ticketing member where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				while(rs.next()) {
					ticket = new TicketDTO();
					ticket.setId(id);
					ticket.setTno(rs.getInt("tno"));
					ticket.setPno(rs.getInt("pno"));
					ticket.setSeat(rs.getString("seat"));
					ticket.setTdate(rs.getString("tdate"));
					tkList.addElement(ticket);
				}
				return tkList;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {if(rs!=null) rs.close();} catch(Exception e) {}
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return null;
		}
		
		// 예매 정보 조회 메소드
				public Vector<TicketDTO> selectTicketByAdmin(String id) {	
					connect();
					TicketDTO ticket;
					Vector<TicketDTO> tkList = new Vector<TicketDTO>();
					try {
						String sql = "select * from ticketing,open_performance where ticketing.pno = open_performance.pno and open_performance.id = ?";
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, id);
						rs = psmt.executeQuery();
						while(rs.next()) {
							ticket = new TicketDTO();
							ticket.setId(id);
							ticket.setTno(rs.getInt("tno"));
							ticket.setPno(rs.getInt("ticketing.pno"));
							ticket.setSeat(rs.getString("seat"));
							ticket.setTdate(rs.getString("tdate"));
							tkList.addElement(ticket);
						}
						return tkList;
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {if(rs!=null) rs.close();} catch(Exception e) {}
						try {if(psmt!=null) psmt.close();} catch(Exception e) {}
						try {if(conn!=null) conn.close();} catch(Exception e) {}
					}
					return null;
				}
		

		public boolean cancelTicket(String id ,int tno) {
			connect();
			try {
				String sql ="delete from ticketing where id = ? and tno = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setInt(2, tno);
				if(psmt.executeUpdate()==1) return true;
				else return false;
				
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {if(psmt!=null) psmt.close();} catch(Exception e) {}
				try {if(conn!=null) conn.close();} catch(Exception e) {}
			}
			return false;
		}
		
		public Vector<TicketDTO> adminTicketCurrent(int pno){
			connect();
			try {
				Vector<TicketDTO> tkList = new Vector<TicketDTO>();
				TicketDTO tk;
				String sql = "select * from ticketing where pno = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, pno);
				
				rs = psmt.executeQuery();
				while(rs.next()) {
					tk = new TicketDTO();
					tk.setId(rs.getString("id"));
					tk.setTno(rs.getInt("tno"));
					tk.setSeat(rs.getString("seat"));
					tk.setTdate(rs.getString("tdate"));
					tkList.addElement(tk);
				}
				return tkList;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		public boolean searchByPno(int pno) {
			connect();
			String sql ="select * from ticketing where pno = ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, pno);
				rs = psmt.executeQuery();
				
				return rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
}
