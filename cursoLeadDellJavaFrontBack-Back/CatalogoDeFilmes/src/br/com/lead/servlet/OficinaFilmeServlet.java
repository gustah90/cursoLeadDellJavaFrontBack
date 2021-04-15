package br.com.lead.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lead.modelo.Filme;

@WebServlet("/infofilme")
public class OficinaFilmeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Filme coringa = new Filme("Coringa", "Drama", 2019);
		Filme matrix = new Filme("Matrix", "A��o", 1999);
		Filme forrestGump = new Filme("Forrest Gump", "Drama", 1994);
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		filmes.add(coringa);
		filmes.add(matrix);
		filmes.add(forrestGump);
		
		String nome = req.getParameter("nome");
	
		ArrayList<Filme> infoFilme = filmes.stream().filter(filme -> filme.getNome().toUpperCase().equals(nome.toUpperCase()))
				.collect(Collectors.toCollection(ArrayList::new));
		
		req.setAttribute("infoFilme", infoFilme);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/infofilme.jsp");
		dispatcher.forward(req, resp);
		
	}

}
