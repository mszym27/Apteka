package logowanie;

import java.sql.*;
import java.util.ArrayList;


public class Jack {
	
	--------------Ogólne-----------------	
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public Jack(String user, String password) throws SQLException {
		String connectionUrl = "jdbc:sqlserver://localhost;" + 
				"user=" + user + ";" + 						 
				"password=" + password + ";" +
				"databaseName=" + "Projekt;" + ";";///////////////

    		con = DriverManager.getConnection(connectionUrl);
    		stmt = con.createStatement();

	}

	--------------Pacjenci-----------------		
	
	public void dodaj(String imie, String nazwisko, String PESEL, String Telefon, String Ulica, 
			String Nr_Mieszkania, String Nr_Lokalu, String Kod_Pocztowy, String Miasto, String Uprawnienia) throws SQLException {
		String SQL = "INSERT INTO Pacjenci(Imie, Nazwisko, PESEL, Data_Urodzenia, Plec, Telefon, "
				+ "Ulica, Nr_Mieszkania, Nr_Lokalu, Kod_Pocztowy, Miasto, Uprawnienia) VALUES('" + 
				imie  + "', '" +
				nazwisko  + "', dbo.walidacja_peselu(" + 
				PESEL  + "), " +
				"SUBSTRING('" + PESEL + "',1,6), " +
				"dbo.ustawplec(" + PESEL + "), '" +
				Telefon  + "', '" + 
				Ulica  + "', " + 
				Nr_Mieszkania  + ", " + 
				Nr_Lokalu  + ", '" + 
				Kod_Pocztowy  + "', '" + 
				Miasto  + "', '" + 
				Uprawnienia + "');";
		stmt.executeUpdate(SQL);
	}
	
	public void modyfikuj(String ID, String imie, String nazwisko, String PESEL, String Uprawnienia, 
			String telefon, String Ulica, String Nr_Mieszkania, String Nr_Lokalu, String Kod_Pocztowy, String Miasto) throws SQLException {
		String SQL = "UPDATE pacjenci SET " + 
				"Imie = '" + imie  + "', " +
				"Nazwisko = '" + nazwisko  + "', " + 
				"PESEL =" + PESEL + ", Data_Urodzenia =" +
				"SUBSTRING('" + PESEL + "',1,6), " +
				"Telefon = '" + telefon  + "', " + 
				"Ulica = '" + Ulica  + "', " +
				"Nr_Mieszkania = " + Nr_Mieszkania + "," +
				"Nr_Lokalu = " + Nr_Lokalu + "," +
				"Kod_Pocztowy = '" + Kod_Pocztowy  + "', " +
				"Miasto = '" + Miasto  + "', Uprawnienia = '" +
				Uprawnienia + "', " + 
				"Plec = dbo.ustawplec(" + PESEL + ") " +
				"WHERE IDPacjenta = " + ID;
		stmt.executeUpdate(SQL);
	}
	
	public void delete(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM pacjenci WHERE IDpacjenta = " + ID + ";");
	}
	
	public String[][] sercz(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM pacjenci WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[13];//il. kolumn 11
			for(int i = 1; i < 14; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] select() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("select * from pacjenci");
		String[] temp;
		while (rs.next()) {
			temp = new String[13];//il. kolumn
			for(int i = 1; i < 14; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	--------------Wizyty-----------------	
	
	public String[][] selectWizyty(String data) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT l.imie+' '+ l.nazwisko, Godzina_Wizyty, "
				+ "p.imie+' '+p.nazwisko, p.Telefon, "
				+ "IDWizyty "
				+ "FROM Zapisy z INNER JOIN Pacjenci p ON z.IDPacjenta = p.IDPacjenta "
				+ "INNER JOIN Lekarze l ON l.IDLekarza = z.IDLekarza "
				+ "where Data_wizyty = '" + 
				data +
				"' ORDER BY l.nazwisko, Godzina_Wizyty");
		String[] temp;
		while (rs.next()) {
			temp = new String[5];//il. kolumn
			for(int i = 1; i < 6; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] selectWizytyDlaLekarza(String data, String IDlekarza) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT Godzina_Wizyty, p.imie +' '+ p.nazwisko, p.Telefon, "
				+ "IDWizyty FROM Zapisy z "
				+ "INNER JOIN Pacjenci p ON z.IDPacjenta = p.IDPacjenta "
				+ "INNER JOIN Lekarze l ON l.IDLekarza = z.IDLekarza "
				+ "where Data_wizyty = '" + 
				data +
				"'  AND l.IDLekarza =" +
				IDlekarza + " ORDER BY Godzina_Wizyty");
		String[] temp;
		while (rs.next()) {
			temp = new String[3];//il. kolumn
			for(int i = 1; i < 4; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public void addWizyte(String IDPacjenta, String IDLekarza, String Data_Wizyty, String Godzina_Wizyty) throws SQLException {
		String SQL = "INSERT INTO Zapisy(IDPacjenta,IDLekarza,Data_Wizyty,Godzina_Wizyty) VALUES(" + 
				IDPacjenta  + ", " +
				IDLekarza + ", '" + 
				Data_Wizyty + "', '" + 
				Godzina_Wizyty + "');";
		stmt.executeUpdate(SQL);
		
	}
	
	public void deleteWizyte(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM Zapisy WHERE IDWizyty = " + ID + ";");
	}
	
	--------------Grafik-----------------	
	
	public String[][] selectSchedules() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT l.imie+' '+l.nazwisko AS 'Lekarz', g.Pon_Godz+' '+g.Pon_Pok, g.Wt_Godz+' '+g.Wt_Pok,"
				+ " g.Srd_Godz+' '+g.Srd_Pok, g.Czw_Godz+' '+g.Czw_Pok,g.Ptk_Godz+' '+g.Ptk_Pok,"
				+ " Opis, g.IDLekarza FROM Grafik g INNER JOIN Lekarze l ON l.IDLekarza = g.IDLekarza");///
		String[] temp;
		while (rs.next()) {
			temp = new String[8];//il. kolumn ///
			for(int i = 1; i < 9; i++) {//< il. kolumn + 1 ////
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public static String[] selectIDLekarzy() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		rs = stmt.executeQuery("Select CONVERT(varchar(3), IDLekarza) + ' -  '  +  Imie + ' ' +  Nazwisko from lekarze");
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		return list.toArray(new String[list.size()]);
	}
	
	public void deleteSchedule(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM Grafik WHERE IDLekarza = " + ID + ";");
	}
	
	public void addSchedule(String IDLekarza, String Pon_Godz, String Pon_Pok, String Wt_Godz, String Wt_Pok, String Srd_Godz, String Srd_Pok, 
			String Czw_Godz, String Czw_Pok, String Ptk_Godz, String Ptk_Pok, String Opis) throws SQLException {
		String SQL = "INSERT INTO Grafik (IDLekarza, Pon_Godz, Pon_Pok, Wt_Godz, Wt_Pok,"
				+ " Srd_Godz, Srd_Pok, Czw_Godz, Czw_Pok, Ptk_Godz, Ptk_Pok, Opis) VALUES(" + 
				IDLekarza  + ", '" +
				Pon_Godz + "', '" + 
				Pon_Pok + "', '" + 
				Wt_Godz + "', '" + 
				Wt_Pok + "', '" + 
				Srd_Godz + "', '" + 
				Srd_Pok + "', '" + 
				Czw_Godz + "', '" + 
				Czw_Pok + "', '" + 
				Ptk_Godz + "', '" + 
				Ptk_Pok + "', '" + 			 
				Opis + "');";
		stmt.executeUpdate(SQL);
	}
	
	--------------Karta_wizyt-----------------	
	
	public String[][] selecDoKartyWizyt(String ID) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		//10
		rs = stmt.executeQuery("select data_wizyty, godzina_wizyty from zapisy where idpacjenta = " + ID + " order by data_wizyty, godzina_wizyty");
		String[] temp;
		while (rs.next()) {
			temp = new String[2];//il. kolumn
			for(int i = 1; i < 3; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[] selectDaneWybranegoPacjenta(String ID) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		rs = stmt.executeQuery("Select * from pacjenci where idpacjenta =" + ID);
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		return list.toArray(new String[list.size()]);
	}
	
	public String[] selectWszystkieDaneWybranegoPacjenta(String ID) throws SQLException {
		rs = stmt.executeQuery("Select * from pacjenci where idpacjenta =" + ID);
		String[] temp;
		temp = new String[15];//il. kolumn
		rs.next();
		for(int i = 1; i < 14; i++) {//< il. kolumn + 1
			temp[i - 1] = rs.getString(i);
		}
		rs = stmt.executeQuery("select CONVERT (date, GETDATE())");
		rs.next();
		temp[13] = rs.getString(1);
		rs = stmt.executeQuery("select l.Imie + ' ' + l.nazwisko from Karta_Kardiologia k "
				+ "INNER JOIN Lekarze l ON l.IDLekarza = k.lekarz where pacjent = " + ID);
		rs.next();
		temp[14] = rs.getString(1);
		return temp;
	}
	
	public String[] selectRzadZKarty(String ID) throws SQLException {
		rs = stmt.executeQuery("select * from Karta_Kardiologia where pacjent = " + ID);
		String[] temp;
		temp = new String[5];//il. kolumn
		rs.next();
		for(int i = 3; i < 8; i++) {//< il. kolumn + 1
			temp[i - 3] = rs.getString(i);
		}
		return temp;
	}
	
	--------------Apteka zaplecze-----------------
	
	//Apteka_Zaplecze 
	
	public String[][] selectZZaplecza() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("select * from Apteka");
		String[] temp;
		while (rs.next()) {
			temp = new String[7];//il. kolumn
			for(int i = 1; i < 8; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] selectZMagazynu() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("select * from Magazyn");
		String[] temp;
		while (rs.next()) {
			temp = new String[5];//il. kolumn
			for(int i = 1; i < 6; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] selectZDostawcow() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("select * from Dostawcy ");
		String[] temp;
		while (rs.next()) {
			temp = new String[7];//il. kolumn
			for(int i = 1; i < 8; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public String[][] selectZeSprzedazy() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("select * from Sprzedaz ");
		String[] temp;
		while (rs.next()) {
			temp = new String[6];//il. kolumn
			for(int i = 1; i < 7; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] selectZeZrealizowanychRecept() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("select * from Zrealizowane_Recepty  ");
		String[] temp;
		while (rs.next()) {
			temp = new String[4];//il. kolumn
			for(int i = 1; i < 5; i++) {//< il. kolumn + 1
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public String[][] serczZaplecze(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM Apteka_Zaplecze WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[7];//il. kolumn 11
			for(int i = 1; i < 8; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public String[][] serczMagazyn(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM Magazyn  WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[5];//il. kolumn 11
			for(int i = 1; i < 6; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] serczDostawcow(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM Dostawcy  WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[7];//il. kolumn 11
			for(int i = 1; i < 8; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] serczSprzedaz(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM Sprzedaz WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[5];//il. kolumn 11
			for(int i = 1; i < 6; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}
	
	public String[][] serczRecepty(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM Zrealizowane_Recepty WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[4];//il. kolumn 11
			for(int i = 1; i < 5; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public void updateRecepty(String data1, String data2, String kod, String ID) throws SQLException {
		String SQL = "UPDATE Zrealizowane_Recepty SET " + 
				"Data_Wystawienia = '" + data1  + "', " +
				"Data_Zrealizowania = '" + data2  + "', " + 
				"Kod_Recepty = '" + kod + "' " + 
				"WHERE IDRecepty = " + ID;
		stmt.executeUpdate(SQL);		
	}

	public void dodajRecepte(String data1, String data2, String kod) throws SQLException {
		String SQL = "INSERT INTO Zrealizowane_Recepty (Data_Wystawienia, Data_Zrealizowania, Kod_Recepty) Values ('" + 
				data1  + "', '" +
				data2  + "', '" + 
				kod + "')";
		stmt.executeUpdate(SQL);
	}

	public void deleteRecepte(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM Zrealizowane_Recepty WHERE IDRecepty = " + ID + ";");
	}

	public void dodajOrder(String nazw, String tele, String ulic, String nrmie, String kodp, String mias) throws SQLException {
		String SQL = "INSERT INTO Dostawcy (Nazwa, Telefon, Ulica, Nr_Mieszkania, Kod_Pocztowy, Miasto) Values ('" + 
				nazw  + "', '" +
				tele  + "', '" + 
				ulic  + "', " + 
				nrmie  + ", '" + 
				kodp  + "', '" + 
				mias  + "')";
		stmt.executeUpdate(SQL);
	}

	public void updateOrder(String ID, String nazw, String tele, String ulic, String nrmie, String kodp, String mias) throws SQLException {
		String SQL = "UPDATE Dostawcy SET " + 
				"Nazwa = '" + nazw  + "', " +
				"Telefon = '" + tele  + "', " + 
				"Ulica = '" + ulic + "', " + 
				"Nr_Mieszkania = " + nrmie + ", " + 
				"Kod_Pocztowy = '" + kodp + "', " + 
				"Miasto = '" + mias + "' " + 
				"WHERE IDDostawcy = " + ID;
		stmt.executeUpdate(SQL);
	}

	public void deleteOrder(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM Dostawcy WHERE IDDostawcy = " + ID + ";");
	}

	public void addSprzedaz(String prod, String ilos, String cena) throws SQLException {
		String SQL = "INSERT INTO Sprzedaz(Produkt,Ilosc,Cena_szt,Koszt)  Values ('" + 
				prod  + "', " +
				ilos  + ", " + 
				cena  + ", dbo.koszt(" + 
				ilos  + ", " + 
				cena  + "))";
		stmt.executeUpdate(SQL);
	}

	public void updateRealization(String ID, String data, String prod, String ilos, String cena) throws SQLException {
		String SQL = "UPDATE Sprzedaz SET " + 
				"Data_Sprzedazy = '" + data + "', " +
				"Produkt = '" + prod  + "', " +
				"Ilosc = " + ilos  + ", " + 
				"Cena_szt = " + cena + ", " + 
				"Koszt = dbo.koszt(" + 
				ilos  + ", " + 
				cena  + ")" +
				"WHERE IDSprzedaz = " + ID;
		stmt.executeUpdate(SQL);
	}

	public void deleteSprzedaz(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM Sprzedaz WHERE IDSprzedaz = " + ID + ";");
	}

	public void updateKartaKardiologa(String data1, String wawiad, String nr, String teknie, String data2, String ID) throws SQLException {
		String SQL = "update Karta_Kardiologia set " + 
				"data = '" + data1 + "', " +
				"wywiad = '" + wawiad + "', " +
				"Pierwsze_Zachorowanie = '" + teknie + "', " +
				"Niezdolnosc_pracy_do = '" + data2 + "', " +
				"Nr_choroby = " + nr + " " +
				"WHERE pacjent = " + ID;
		stmt.executeUpdate(SQL);
		
	}

	public String[][] selectZZamowien() throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM zamowienia;");
		String[] temp;
		while (rs.next()) {
			temp = new String[6];//il. kolumn 11
			for(int i = 1; i < 7; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public String[][] serczZamowienia(String column, String value) throws SQLException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		rs = stmt.executeQuery("SELECT * FROM zamowienia WHERE " + column + " like '" + value + "%';");//=
		String[] temp;
		while (rs.next()) {
			temp = new String[6];//il. kolumn 11
			for(int i = 1; i < 7; i++) {//< il. kolumn + 1 12
				temp[i - 1] = rs.getString(i);
			}
			list.add(temp);
		}
		return list.toArray(new String[0][]);
	}

	public void dodajZamowienie(String nazw, String ilo, String kosz, String dat1, String dat2) throws SQLException {
		String SQL = "INSERT INTO Zamowienia(IDLeku,Ilosc,Koszt_jednostkowy,Cena,Data_Zamowienia,Data_Dostarczenia) Values (" + 
				nazw  + ", " +
				ilo  + ", " + 
				kosz  + ", ROUND(" + 
				ilo  + "*" + 
				kosz  + ",2)" + ", '" +
				dat1 + "', '" +
				dat2 + "');";
		stmt.executeUpdate(SQL);
	}

	public void modyfikujZamowienie(String ilo, String kosz, String dat1, String dat2, String ID) throws SQLException {
		String SQL = "update Zamowienia set " + 
				"Ilosc =" + ilo  + ", " + 
				"Koszt_jednostkowy = " + kosz  + ", Cena = ROUND(" + 
				ilo  + "*" + 
				"" + kosz  + ",2)" + ", " +
				"Data_Zamowienia = '" + dat1 + "', Data_Dostarczenia = '" +
				dat2 + "' where IDLeku =" +
				ID;
		System.out.println(SQL);
		stmt.executeUpdate(SQL);
		
	}

	public void deleteZamowienie(String ID) throws SQLException {
		stmt.executeUpdate("DELETE FROM zamowienia WHERE IDLeku = " + ID + ";");
	}
	
}

