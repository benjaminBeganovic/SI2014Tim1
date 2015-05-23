package ba.unsa.etf.si.projekt.ServisnaImplementacija;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import ba.unsa.etf.si.projekt.Util.HibernateUtil;
import ba.unsa.etf.si.projekt.Klase.*;
import ba.unsa.etf.si.projekt.ServisniInterfejs.*;

public class KompanijaFacade implements IKompanijaFacade {
	
		public List<Osoba> listaOsoba(TipOsobe tip)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			List<Osoba> _osobe = null;
			if(tip.equals(TipOsobe.menadzer)) {
				_osobe = session.createCriteria(Menadzer.class).list();
			}
			else if(tip.equals(TipOsobe.klijent)) {
				_osobe = session.createCriteria(Klijent.class).list();
			}
			else if(tip.equals(TipOsobe.radnik)) {
				_osobe = session.createCriteria(Radnik.class).list();
			}
			t.commit();
			session.close();
			return _osobe;
		}
		
		public Osoba returnById(long id, TipOsobe tip) 
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Osoba osoba = null;
			try {
				Transaction t = session.beginTransaction();
				if(tip == TipOsobe.klijent)
					osoba = (Klijent)session.get(Klijent.class, id);
				else if(tip == TipOsobe.radnik)
					osoba = (Radnik)session.get(Radnik.class, id);
				else if(tip == TipOsobe.menadzer)
					osoba = (Menadzer)session.get(Menadzer.class, id);
				t.commit();
				return osoba;
			}
			catch(Exception e) {
				return osoba;
			}
			finally {
				session.close();
			}
		}
		
		public Osoba returnByImePrezime(String ime, String prezime, TipOsobe tip)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Osoba m = null;
			try {
			if(TipOsobe.menadzer == tip) {
				Transaction t = session.beginTransaction();
				String hql = "FROM Menadzer M WHERE M.ime = :ime_p AND M.prezime = :prezime_p";
				Query query = session.createQuery(hql).setParameter("ime_p", ime).setParameter("prezime_p", prezime);
				List rezultati = query.list();
				ArrayList<Menadzer> lista = new ArrayList<Menadzer> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Menadzer m1 = (Menadzer)iterator1.next(); 
				    lista.add(m1);
			    }
				if(lista.size() == 1) {
					m = lista.get(0);
				}
				t.commit();
				return m;
			}
			else if(TipOsobe.klijent == tip) {
				Transaction t = session.beginTransaction();
				String hql = "FROM Klijent K WHERE K.ime = :ime_p AND K.prezime = :prezime_p";
				Query query = session.createQuery(hql).setParameter("ime_p", ime).setParameter("prezime_p", prezime);
				List rezultati = query.list();
				ArrayList<Klijent> lista = new ArrayList<Klijent> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Klijent m1 = (Klijent)iterator1.next(); 
				    lista.add(m1);
			    }
				if(lista.size() == 1) {
					m = lista.get(0);
				}
				t.commit();
				return m;
			}
			else if(TipOsobe.radnik == tip) {
				Transaction t = session.beginTransaction();
				String hql = "FROM Radnik R WHERE R.ime = :ime_p AND R.prezime = :prezime_p";
				Query query = session.createQuery(hql).setParameter("ime_p", ime).setParameter("prezime_p", prezime);
				List rezultati = query.list();
				ArrayList<Radnik> lista = new ArrayList<Radnik> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Radnik m1 = (Radnik)iterator1.next(); 
				    lista.add(m1);
			    }
				if(lista.size() == 1) {
					m = lista.get(0);
				}
				t.commit();
				return m;
			}
			else {
				return m;
			}
			}
			catch(Exception e) {
				return m;
			}
			finally {
				session.close();
			}
		}
		
		public Boolean dodajKlijenta(String ime, String prezime, String brojTelefona, String adresa, String email, List<Narudzbenica> narudzbe)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				Klijent k = new Klijent(ime, prezime, brojTelefona, adresa, email, narudzbe);
				Long id = (Long) session.save(k);
				k.setId(id);
				t.commit();
				return true;
			}
			catch(Exception e) {
				return false;
			}
			finally {
				session.close();
			}
		}
		
		public Boolean dodajRadnika(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password, String JMBG)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				Radnik m = new Radnik(ime, prezime, brojTelefona, adresa, email, pozicija, nivoOvlasti, username, password, JMBG);
				Long id = (Long) session.save(m);
				m.setId(id);
				t.commit();
				return true;
			}
			catch(Exception e) {
				return false;
			}
			finally {
				session.close();
			}
		}
		
		public Boolean dodajMenadzera(String ime, String prezime, String brojTelefona, String adresa, String email, String pozicija, Ovlasti nivoOvlasti, String username, String password, String JMBG)
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				Menadzer m = new Menadzer(ime, prezime, brojTelefona, adresa, email, pozicija, nivoOvlasti, username, password, JMBG);
				Long id = (Long) session.save(m);
				m.setId(id);
				t.commit();
				return true;
			}
			catch(Exception e) {
				return false;
			}
			finally {
				session.close();
			}
			
		}
		
		public Boolean mijenjajKlijenta(Klijent k) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(k);
				t.commit();
				return true;
			}
			catch (Exception e) {
				return false;
			}
			finally {
				session.close();
			}	
		}
		
		public Boolean mijenjajRadnika(Radnik r) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(r);
				t.commit();
				return true;
			}
			catch (Exception e) {
				return false;
			}
			finally {
				session.close();
			}	
		}
		
		public Boolean mijenjajMenadzera(Menadzer m) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.update(m);
				t.commit();
				return true;
			}
			catch (Exception e) {
				return false;
			}
			finally {
				session.close();
			}	
		}
		
		public Boolean obrisiOsobu(Osoba osoba)
		{
			if(osoba.getTipOsobe() == TipOsobe.klijent)
				osoba = (Klijent) osoba;
			else if(osoba.getTipOsobe() == TipOsobe.radnik)
				osoba = (Radnik) osoba;
			else if(osoba.getTipOsobe() == TipOsobe.menadzer)
				osoba = (Menadzer) osoba;
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Transaction t = session.beginTransaction();
				session.delete(osoba);
				t.commit();
				return true;
			}
			catch (Exception e) {
				return false;
			}
			finally {
				session.close();
			}
		}
		
		
		public Osoba returnByUsernamePassword(String username, String password) {
			Menadzer m1 = (Menadzer) dajMenadzeraUsernamePassword(username, password);
			if(m1 == null) {
				Session session = HibernateUtil.getSessionFactory().openSession();
				Osoba m = null;
				try {
					Transaction t = session.beginTransaction();
					String hql = "FROM Radnik R WHERE R.username = :user_p AND R.password = :pass_p";
					Query query = session.createQuery(hql).setParameter("user_p", username).setParameter("pass_p", password);
					List rezultati = query.list();
					ArrayList<Radnik> lista = new ArrayList<Radnik> ();
					for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
					{
						Radnik m2 = (Radnik)iterator1.next(); 
					    lista.add(m2);
					   }
					if(lista.size() == 1) {
					m = lista.get(0);
					}
					t.commit();
					return m;
				}
				catch(Exception e) {
					return m;
				}
				finally {
					session.close();
				}
			}
			else {
				return m1;
			}
		}
		
		public Osoba dajMenadzeraUsernamePassword(String username, String password) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Osoba m = null;
			try {
				Transaction t = session.beginTransaction();
				String hql = "FROM Menadzer M WHERE M.username = :user_p AND M.password = :pass_p";
				Query query = session.createQuery(hql).setParameter("user_p", username).setParameter("pass_p", password);
				List rezultati = query.list();
				ArrayList<Menadzer> lista = new ArrayList<Menadzer> ();
				for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
				{
					Menadzer m1 = (Menadzer)iterator1.next(); 
				    lista.add(m1);
				   }
				if(lista.size() == 1) {
				m = lista.get(0);
				}
				t.commit();
				return m;
			}
			catch(Exception e) {
				return m;
			}
			finally {
				session.close();
			}
		}
}
