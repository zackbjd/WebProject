package book.list;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class BookDAO {

    public List<Book> findAll() {
        List<Book> list = new ArrayList<Book>();
        Connection c = null;
    	String sql = "SELECT * FROM books";
        try {
            c = DbConnector.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			DbConnector.close(c);
		}
        return list;
    }
    
    public Book findById(int id) {
    	String sql = "SELECT  * FROM books WHERE id = ?";
    	Book book = null;
    	Connection c = null;
    	try {
    		c = DbConnector.getConnection();
    		PreparedStatement ps = c.prepareStatement(sql);
    		ps.setInt(1, id);
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {	
    			book = processRow(rs);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new  RuntimeException(e);
    	}finally {
    		DbConnector.close(c);
    	}
    	return book;
    }
    
    public Book update(Book book) {
		Connection c = null;
		try {
			c = DbConnector.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE books SET year=?, book_name=?, author=?, num_pages=?, theme=?, price=?, rating=? WHERE ID=?");
			ps.setString(1, book.getYear());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPages());
			ps.setString(5, book.getTheme());
			ps.setString(6, book.getPrice());
			ps.setString(7, book.getRating());
			ps.setInt(8, book.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally { 
			DbConnector.close(c);
		}
		return book;
	}
    
    public Book create(Book book) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c=DbConnector.getConnection();
			ps = c.prepareStatement("INSERT INTO books (year, book_name, author, num_pages, theme, price, rating) VALUES (?, ?, ?, ?, ?, ?, ?)",
					new String[] { "ID" });
			ps.setString(1, book.getYear());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPages());
			ps.setString(5, book.getTheme());
			ps.setString(6, book.getPrice());
			ps.setString(7, book.getRating());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();

			int id = rs.getInt(1);
			book.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbConnector.close(c);
		}
		return book;
	}

    public boolean remove(int id) {
		Connection c = null;
		try {
			c = DbConnector.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM books WHERE id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally { 
			DbConnector.close(c);
		}
	}
    
    public List<Book> findByName(String name){
		List<Book> list = new ArrayList<>();
		Connection c = null;
		String sql = "SELECT * FROM books as e WHERE book_name LIKE ? ORDER BY book_name";
		try {
			c = DbConnector.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbConnector.close(c);
		}
		return list;
	}
    
   
    protected Book processRow(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setYear(rs.getString("year"));
        book.setName(rs.getString("book_name"));
        book.setAuthor(rs.getString("author"));
        book.setPages(rs.getString("num_pages"));
        book.setTheme(rs.getString("theme"));
        book.setPrice(rs.getString("price"));
        book.setRating(rs.getString("rating"));
        book.setPicture(rs.getString("picture"));
        
        return book;
    }
    
}
