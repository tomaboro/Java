/**
 * Created by Tomek on 05.12.2016.
 */

import java.sql.*;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/motek",
                            "motek","PgF5bdVH");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }


    public void listDB(){
        try {
            connect();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                System.out.println( rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Wystąpił błąd! Operacja zakończona niepowodzeniem!");;
            ex.getMessage();
        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public void searchByISBN(String isbn){
        try {
            connect();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM books WHERE isbn='"+isbn+"'");

            while (rs.next()) {
                System.out.println( rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("Wystąpił błąd! Operacja zakończona niepowodzeniem!");

        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public void deleteByAuthor(String author) {
        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM books WHERE author = '" + author + "'");
            System.out.println("Z bazy danych usunięto wszystkie pozycje autora "+author);
        } catch (SQLException ex) {
            System.out.println("Wystąpił błąd! Operacja zakończona niepowodzeniem!");
        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public void deleteByISBN(String isbn) {
        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM books WHERE isbn = '" + isbn + "'");
            System.out.println("Z bazy danych usunięto pozycję o nr ISBN: "+isbn);
        } catch (SQLException ex) {
            System.out.println("Wystąpił błąd! Operacja zakończona niepowodzeniem!");
        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public void addToDB(String isbn, String title, String autor, int year) {
        try {
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO books VALUES ('"+ isbn +"','"+ title + "','" + autor +"'," + year +")");
            System.out.println("Pomyślnie dodano pozycję.");
        } catch (SQLException ex) {
            System.out.println("Wystąpił błąd! Operacja zakończona niepowodzeniem!");
            ex.getMessage();
        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public void listNames() {
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT title FROM books");

            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println("Uzytkownik: " + name);
            }
        } catch (SQLException ex) {
            // handle any errors

        } finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }
}

