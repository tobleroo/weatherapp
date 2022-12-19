package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetSearchHistory;
import model.GetTheWeather;
import model.SearchHistoryObject;
import model.WeatherBean;

@WebServlet("/OWservlet")
public class OWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// get params from user form inputs
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		// if user accepts cookies or not (true false)
		String acceptCookiesOrNot = request.getParameter("acceptCookiesBool");
		
		Cookie [] cookieList = request.getCookies();
		
		//method to create an array of searchhistoryDTO objects from cookie data
		List<SearchHistoryObject> historySearches = GetSearchHistory.createHistoryList(cookieList);
		
		request.setAttribute("searchHistory", historySearches);
		
		//create bean containing weather data
		WeatherBean wBean = new WeatherBean(cityStr, countryStr);
		// create object to download API data to user later
		GetTheWeather weatherAPI = new GetTheWeather(wBean);
		
		//specific weather data to show user
		wBean.setCloudsStr(weatherAPI.getWeather("clouds", "name"));
		wBean.setSunRise(weatherAPI.getWeather("sun" , "rise"));
		wBean.setLastUpdate(weatherAPI.getWeather("lastupdate", "value"));
		
		request.setAttribute("wBean", wBean);
		
		
		
		// if user accept cookies, the latest search will be added to the cookie
		if(acceptCookiesOrNot == null){
			for(Cookie cookieBool : cookieList){
				if(cookieBool.getValue().equals("true")){
					for(Cookie cookie : cookieList){
						//if the cookie named searchHistory exists, concat new search to existing string.
						//else : create a new cookie and add latest value
						if(cookie.getName().equals("searchHistory")){
							cookie.setValue(cookie.getValue() + "-" + cityStr + "/" + countryStr);
							response.addCookie(cookie);
						}else{
							Cookie searchHistory = new Cookie("searchHistory", cityStr + "/" + countryStr);
							searchHistory.setMaxAge(1800);
							response.addCookie(searchHistory);
						}
					}
				}	
			}
		}else if(acceptCookiesOrNot != null){
			if(acceptCookiesOrNot.equals("true")){
				for(Cookie cookie : cookieList){
					//if the cookie named searchHistory exists, concat new search to existing string.
					//else : create a new cookie and add latest value
					if(cookie.getName().equals("searchHistory")){
						cookie.setValue(cookie.getValue() + "-" + cityStr + "/" + countryStr);
						response.addCookie(cookie);
					}else{
						Cookie searchHistory = new Cookie("searchHistory", cityStr + "/" + countryStr);
						searchHistory.setMaxAge(1800);
						response.addCookie(searchHistory);
					}
				}
			}	
		}
		
		
		//create cookie for accepting cookies or not
		if(acceptCookiesOrNot != null){
			Cookie acceptCookies = new Cookie("acceptCookies", acceptCookiesOrNot);
			response.addCookie(acceptCookies);
		}

		//get cookies 
		request.getSession().setAttribute("city", cityStr);
		RequestDispatcher rd = request.getRequestDispatcher("./showWeather.jsp");
		rd.forward(request, response);
	}
	
}
