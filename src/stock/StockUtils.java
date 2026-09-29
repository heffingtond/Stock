package stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class StockUtils
{
	public static String getCurrentTickerProfile( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/quote";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}
	
	public static String getFinancialScores( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/financial-scores";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}
	
	public static String getEarnings( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/earnings";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}

	public static String getRatingsSnapshot( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/ratings-snapshot";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}

	public static String getCurrentTickerAfterHoursProfile( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/aftermarket-trade";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}
	
	public static String getMarketOpenStatus( String exchange )
	{
		// Return JSON representation of the market status (open or closed).
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/exchange-market-hours";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&exchange=" + exchange;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}

	public static String getCurrentTickerShortProfile( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/quote-short";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}
	
	public static String getTickerTarget( String ticker )
	{
		// Return JSON representation of the ticker profile.
		String returnList = null;
        try 
        {
            // 1. Define the URL of the REST endpoint
        	String endpointUrl = "https://financialmodelingprep.com/stable/price-target-consensus";
        	System.out.println( "endpoint: " + endpointUrl );
        	endpointUrl += "?apikey=" + System.getenv("FMP_API_KEY");
        	endpointUrl += "&symbol=" + ticker;
            @SuppressWarnings("deprecation")
			URL url = new URL( endpointUrl );

            // 2. Open a connection
            HttpURLConnection connection = ( HttpURLConnection ) url.openConnection();

            // 3. Set the request method (e.g., GET, POST, PUT, DELETE)
            connection.setRequestMethod( "GET" );

            // 4. Set request headers (optional, but often necessary for content type, authorization, etc.)
            connection.setRequestProperty("Accept", "application/json");

            // 5. Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 6. Read the response
            if ( responseCode == HttpURLConnection.HTTP_OK ) 
            {
                BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ( ( inputLine = in.readLine() ) != null ) 
                {
                    content.append( inputLine );
                }
                in.close();
                returnList = content.toString();
//                System.out.println( "Response Body: " + content.toString() );
            } 
            else 
            {
                System.out.println( "Error in GET request: " + responseCode );
            }

            // 7. Disconnect the connection
            connection.disconnect();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
		return returnList;
	}
	
	public static boolean isEmpty( String inString )
	{
		boolean isEmpty = false;
		if ( inString == null )
			isEmpty = true;
		else
		{
			inString = inString.trim();
			if ( inString.length() == 0 )
				isEmpty = true;
		}
		return isEmpty;
	}
	
	private static FinancialScoresBean loadFinancialScores( String symbol )
	{
		
		String financialScoresJson = getFinancialScores( symbol );
		
		FinancialScoresBean financialScores = null;
		
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jsonArray = ( JSONArray ) parser.parse( financialScoresJson );
			financialScores = new FinancialScoresBean();
			for ( Object obj : jsonArray ) 
			{
				Object numberObj = null;
				
				JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
				financialScores.setSymbol( ( String ) jsonObject.get( "symbol" ) );
				financialScores.setReportedCurrency( ( String ) jsonObject.get( "reportedCurrency" ) );
				
				numberObj = jsonObject.get("altmanZScore");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "altmanZScore"  );
					financialScores.setAltmanZScore( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "altmanZScore" );
					financialScores.setAltmanZScore( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("piotroskiScore");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "piotroskiScore" );
					financialScores.setPiotroskiScore( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "piotroskiScore" );
					financialScores.setPiotroskiScore( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("workingCapital");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "workingCapital" );
					financialScores.setWorkingCapital( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "workingCapital" );
					financialScores.setWorkingCapital( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("totalAssets");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "totalAssets" );
					financialScores.setTotalAssets( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "totalAssets" );
					financialScores.setTotalAssets( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("retainedEarnings");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "retainedEarnings" );
					financialScores.setRetainedEarnings( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "retainedEarnings" );
					financialScores.setRetainedEarnings( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("ebit");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "ebit" );
					financialScores.setEbit( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "ebit" );
					financialScores.setEbit( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("marketCap");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "marketCap" );
					financialScores.setMarketCap( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "marketCap" );
					financialScores.setMarketCap( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("totalLiabilities");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "totalLiabilities" );
					financialScores.setTotalLiabilities( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "totalLiabilities" );
					financialScores.setTotalLiabilities( Double.toString( priceDouble ) );
				}

				numberObj = jsonObject.get("revenue");
				if ( numberObj instanceof Long )
				{
					long priceLong = ( long ) jsonObject.get( "revenue" );
					financialScores.setRevenue( Long.toString( priceLong ) );
				}
				else
				{
					double priceDouble = ( double ) jsonObject.get( "revenue" );
					financialScores.setRevenue( Double.toString( priceDouble ) );
				}
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		return financialScores;
	
	}
	
	private static ArrayList<EarningsBean> loadEarnings( String symbol )
	{
		
		String earningsJson = getEarnings( symbol );
		
		ArrayList<EarningsBean> allEarnings = new ArrayList<EarningsBean>();
		
		JSONParser parser = new JSONParser();
		try
		{
			EarningsBean earnings = null;
			JSONArray jsonArray = ( JSONArray ) parser.parse( earningsJson );
			for ( Object obj : jsonArray ) 
			{
				earnings = new EarningsBean();
				Object numberObj = null;
				
				JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
				earnings.setSymbol( ( String ) jsonObject.get( "symbol" ) );
				earnings.setDate( ( String ) jsonObject.get( "date" ) );
				
				numberObj = jsonObject.get("epsActual");
				if ( numberObj != null )
				{
					if ( numberObj instanceof Long )
					{
						long priceLong = ( long ) jsonObject.get( "epsActual"  );
						earnings.setEpsActual( Long.toString( priceLong ) );
					}
					else
					{
						double priceDouble = ( double ) jsonObject.get( "epsActual" );
						earnings.setEpsActual( Double.toString( priceDouble ) );
					}
				}
				
				numberObj = jsonObject.get("epsEstimated");
				if ( numberObj != null )
				{
					if ( numberObj instanceof Long )
					{
						long priceLong = ( long ) jsonObject.get( "epsEstimated"  );
						earnings.setEpsEstimated( Long.toString( priceLong ) );
					}
					else
					{
						double priceDouble = ( double ) jsonObject.get( "epsEstimated" );
						earnings.setEpsEstimated( Double.toString( priceDouble ) );
					}
				}

				numberObj = jsonObject.get("revenueActual");
				if ( numberObj != null )
				{
					if ( numberObj instanceof Long )
					{
						long priceLong = ( long ) jsonObject.get( "revenueActual"  );
						earnings.setRevenueActual( Long.toString( priceLong ) );
					}
					else
					{
						double priceDouble = ( double ) jsonObject.get( "revenueActual" );
						earnings.setRevenueActual( Double.toString( priceDouble ) );
					}
				}

				numberObj = jsonObject.get("revenueEstimated");
				if ( numberObj != null )
				{
					if ( numberObj instanceof Long )
					{
						long priceLong = ( long ) jsonObject.get( "revenueEstimated"  );
						earnings.setRevenueEstimated( Long.toString( priceLong ) );
					}
					else
					{
						double priceDouble = ( double ) jsonObject.get( "revenueEstimated" );
						earnings.setRevenueEstimated( Double.toString( priceDouble ) );
					}
				}

				earnings.setLastUpdated( ( String ) jsonObject.get( "lastUpdated" ) );
				
				allEarnings.add( earnings );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		return allEarnings;
	}
	
	private static RatingsSnapshotBean loadRatingsSnapshot( String symbol )
	{
		
		String ratingsJson = getRatingsSnapshot( symbol );
		
		RatingsSnapshotBean ratings = null;
		
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jsonArray = ( JSONArray ) parser.parse( ratingsJson );
			ratings = new RatingsSnapshotBean();
			for ( Object obj : jsonArray ) 
			{
				JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
				ratings.setSymbol( ( String ) jsonObject.get( "symbol" ) );
				ratings.setRating( ( String ) jsonObject.get( "rating" ) );
				ratings.setOverallScore( Long.toString( ( long ) jsonObject.get( "overallScore" ) ) );
				ratings.setDiscountedCashFlowScore( Long.toString( ( long ) jsonObject.get( "discountedCashFlowScore" ) ) );
				ratings.setReturnOnEquityScore( Long.toString( ( long ) jsonObject.get( "returnOnEquityScore" ) ) );
				ratings.setReturnOnAssetsScore( Long.toString( ( long ) jsonObject.get( "returnOnAssetsScore" ) ) );
				ratings.setDebtToEquityScore( Long.toString( ( long ) jsonObject.get( "debtToEquityScore" ) ) );
				ratings.setPriceToEarningsScore( Long.toString( ( long ) jsonObject.get( "priceToEarningsScore" ) ) );
				ratings.setPriceToBookScore( Long.toString( ( long ) jsonObject.get( "priceToBookScore" ) ) );
			}				
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		return ratings;
	
	}
	
	private static ArrayList<DisplayDataBean> runAnalysis( ArrayList<QuoteBean> tickerData, String deltaPercent )
	{
		ArrayList<DisplayDataBean> displayData = new ArrayList<DisplayDataBean>();
		
		if ( isEmpty( deltaPercent ) ) // List all, no delta check
		{
			for( QuoteBean quote : tickerData )
			{
				// Financial scores:
				//	- All results with an Altman-Z < 3.0, High probability of bankruptcy in next 2 years. 
				//	- All results with a Piotroski score < 5, Weak financial health. 

				FinancialScoresBean financialScoresBean = loadFinancialScores( quote.getSymbol() );
				RatingsSnapshotBean ratings = loadRatingsSnapshot( quote.getSymbol() );
				ArrayList<EarningsBean> allEarnings = loadEarnings( quote.getSymbol() );


				DisplayDataBean display = new DisplayDataBean();
				display.setChangePercentage( quote.getChangePercentage() );
				display.setName( quote.getName() );
				display.setPreviousClose( quote.getPreviousClose() );
				display.setDayHigh( quote.getDayHigh() );
				display.setDayLow( quote.getDayLow() );
				display.setOpen( quote.getOpen() );
				display.setVolume( quote.getVolume() );
				display.setPrice( quote.getPrice() );
				display.setSymbol( quote.getSymbol() );
				display.setRating( ratings.getRating() );
				display.setAltmanZScore( financialScoresBean.getAltmanZScore() );
				display.setPiotroskiScore( financialScoresBean.getPiotroskiScore() );
				display.getAllEarnings().clear();
				display.getAllEarnings().addAll( allEarnings );
				display.setTimestamp( quote.getTimestamp() );
				displayData.add( display );
			}
		}
		else  // perform delta check
		{
			// convert the percentages to decimal
			BigDecimal negatedDeltaPercentDecimal = new BigDecimal( deltaPercent );
			if ( negatedDeltaPercentDecimal.doubleValue() > 0 )
				negatedDeltaPercentDecimal = negatedDeltaPercentDecimal.negate();
			
			System.out.println( "User-entered negated delta is " + negatedDeltaPercentDecimal );
			
			for( QuoteBean quote : tickerData )
			{
				// convert the percentage change for the ticker to decimal
				BigDecimal quotePercentDecimal = new BigDecimal( quote.getChangePercentage() );
				if ( quotePercentDecimal.doubleValue() <= negatedDeltaPercentDecimal.doubleValue() )
				{
					// Financial scores:
					//	- All results with an Altman-Z < 3.0, High probability of bankruptcy in next 2 years. 
					//	- All results with a Piotroski score < 5, Weak financial health. 

					FinancialScoresBean financialScoresBean = loadFinancialScores( quote.getSymbol() );
					RatingsSnapshotBean ratings = loadRatingsSnapshot( quote.getSymbol() );
					ArrayList<EarningsBean> allEarnings = loadEarnings( quote.getSymbol() );

					DisplayDataBean display = new DisplayDataBean();
					display.setChangePercentage( quote.getChangePercentage() );
					display.setName( quote.getName() );
					display.setPreviousClose( quote.getPreviousClose() );
					display.setDayHigh( quote.getDayHigh() );
					display.setDayLow( quote.getDayLow() );
					display.setOpen( quote.getOpen() );
					display.setVolume( quote.getVolume() );
					display.setPrice( quote.getPrice() );
					display.setSymbol( quote.getSymbol() );
					display.setRating( ratings.getRating() );
					display.setAltmanZScore( financialScoresBean.getAltmanZScore() );
					display.setPiotroskiScore( financialScoresBean.getPiotroskiScore() );
					display.getAllEarnings().clear();
					display.getAllEarnings().addAll( allEarnings );
					display.setTimestamp( quote.getTimestamp() );
					displayData.add( display );
				}
			}
		}
		
		return displayData;
	}
	
	private static String getTargetConsensus( String ticker, ArrayList<TargetBean> tickerTargetData )
	{
		boolean found = false;
		int i = 0;
		TargetBean target = null;
		while( i < tickerTargetData.size() && ! found )
		{
			target = tickerTargetData.get( i );
			if ( target.getSymbol().equalsIgnoreCase( ticker ) )
				found = true;
			else
				i++;
		}
		
		if ( found )
			return target.getTargetConsensus();
		else
			return null;
	}
	
	private static ArrayList<DisplayPriceToTargetBean> combineTargetResults( ArrayList<QuoteShortBean> tickerShortData,
																			 ArrayList<QuoteAfterHoursBean> tickerAfterHoursData,
																			 ArrayList<TargetBean> tickerTargetData )
	{
		ArrayList<DisplayPriceToTargetBean> displayData = new ArrayList<DisplayPriceToTargetBean>();
		
		for ( QuoteShortBean quoteShort : tickerShortData )
		{
			// Financial scores:
			//	- All results with an Altman-Z < 3.0, High probability of bankruptcy in next 2 years. 
			//	- All results with a Piotroski score < 5, Weak financial health. 
			FinancialScoresBean financialScoresBean = loadFinancialScores( quoteShort.getSymbol() );
			RatingsSnapshotBean ratings = loadRatingsSnapshot( quoteShort.getSymbol() );
			ArrayList<EarningsBean> allEarnings = loadEarnings( quoteShort.getSymbol() );

			DisplayPriceToTargetBean display = new DisplayPriceToTargetBean();
			display.setSymbol( quoteShort.getSymbol() );
			display.setPrice( quoteShort.getPrice() );
			display.setVolume( quoteShort.getVolume() );
			String targetConsensus = getTargetConsensus( quoteShort.getSymbol(), tickerTargetData );
			display.setTargetConsensus( targetConsensus );
			display.setRating( ratings.getRating() );
			display.setAltmanZScore( financialScoresBean.getAltmanZScore() );
			display.setPiotroskiScore( financialScoresBean.getPiotroskiScore() );
			display.getAllEarnings().clear();
			display.getAllEarnings().addAll( allEarnings );
			display.setTimestamp( quoteShort.getTimestamp() );
			displayData.add( display );
		}

		for ( QuoteAfterHoursBean after : tickerAfterHoursData )
		{
			// Financial scores:
			//	- All results with an Altman-Z < 3.0, High probability of bankruptcy in next 2 years. 
			//	- All results with a Piotroski score < 5, Weak financial health. 
			FinancialScoresBean financialScoresBean = loadFinancialScores( after.getSymbol() );
			RatingsSnapshotBean ratings = loadRatingsSnapshot( after.getSymbol() );
			ArrayList<EarningsBean> allEarnings = loadEarnings( after.getSymbol() );
			
			DisplayPriceToTargetBean display = new DisplayPriceToTargetBean();
			display.setSymbol( after.getSymbol() );
			display.setPrice( after.getPrice() );
			String targetConsensus = getTargetConsensus( after.getSymbol(), tickerTargetData );
			display.setTargetConsensus( targetConsensus );
			display.setRating( ratings.getRating() );
			display.setAltmanZScore( financialScoresBean.getAltmanZScore() );
			display.setPiotroskiScore( financialScoresBean.getPiotroskiScore() );
			display.getAllEarnings().clear();
			display.getAllEarnings().addAll( allEarnings );
			display.setTimestamp( after.getTimestamp() );
			displayData.add( display );
		}
		
		return displayData;
	}
	
	public static String padLeft( String text, int len, char padChar ) 
	{
        StringBuilder sb = new StringBuilder();
        if ( text.length() < len ) 
		{
            for ( int i = text.length(); i < len; i++ ) 
			{
                sb.append( padChar );
            }
            sb.append( text );
            return sb.toString();
        }
        return text;
    }

    public static String padRight( String text, int len, char padChar ) 
    {
        StringBuilder sb = new StringBuilder( text );
        if ( text.length() < len ) 
        {
            for ( int i = text.length(); i < len; i++ ) 
            {
                sb.append( padChar );
            }
            return sb.toString();
        }
        return text;
    }
    
	public static String getCurrentNewYorkTime() // HHMM military time 
	{
		Instant instant = Instant.now();
		ZonedDateTime newYorkTime = instant.atZone(ZoneId.of("America/New_York"));
		int hour = newYorkTime.getHour();
		int minute = newYorkTime.getMinute();
		String hourStr = Integer.toString( hour );
		hourStr = padLeft( hourStr, 2, '0' );
		String minuteStr = Integer.toString( minute );
		minuteStr = padLeft( minuteStr, 2, '0' );
		System.out.println("current military New York time is " + hourStr + minuteStr );
		return hourStr + minuteStr;
	}
	
	public static String getCurrentTimestamp()
	{
		Instant instant = Instant.now();
		ZoneId desiredZone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = instant.atZone(desiredZone);
		
        System.out.println("ZonedDateTime in " + desiredZone + ": " + zonedDateTime);

		String convertedTimestamp = zonedDateTime.toString();
		return convertedTimestamp;
	}
	
	public static ArrayList<DisplayDataBean> checkDeltas( String tickers, String deltaPercent )
	{
		// parse tickers
		ArrayList<String> tickerList = new ArrayList<String>();
		String ticker = "";
		for ( Character c : tickers.toCharArray() )
			if ( c.compareTo( ',' ) != 0 )
				ticker += c;
			else
			{
				if ( ticker.length() > 0 )
				{
					ticker = ticker.trim();
					tickerList.add( ticker );
				}
				ticker = "";
			}
		
		// Pick up the last ticker on the list (or the only ticker on the list) 
		if ( ticker.length() > 0 )
		{
			ticker = ticker.trim();
			tickerList.add( ticker );
		}
		
		ArrayList<QuoteBean> tickerData = new ArrayList<QuoteBean>();
		String currentTimestamp = getCurrentTimestamp();
		for ( String element : tickerList )
		{
			String jsonResponse = getCurrentTickerProfile( element );
			
			JSONParser parser = new JSONParser();
			try
			{
				JSONArray jsonArray = ( JSONArray ) parser.parse( jsonResponse );
				QuoteBean returnTickerData = new QuoteBean();
				for ( Object obj : jsonArray ) 
				{
					Object numberObj = null;
					
					JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
					returnTickerData.setSymbol( ( String ) jsonObject.get( "symbol" ) );
					returnTickerData.setName( ( String ) jsonObject.get( "name" )  );
					
					numberObj = jsonObject.get("price");
					if ( numberObj instanceof Long )
					{
						long priceDouble = ( long ) jsonObject.get( "price" );
						returnTickerData.setPrice( Long.toString( priceDouble ) );
					}
					else
					{
						double priceDouble = ( double ) jsonObject.get( "price" );
						returnTickerData.setPrice( Double.toString( priceDouble ) );
					}

					numberObj = jsonObject.get("changePercentage");
					if ( numberObj instanceof Long )
					{
						long changePercentageDouble = ( long ) jsonObject.get( "changePercentage" );
						returnTickerData.setChangePercentage( Long.toString( changePercentageDouble ) );
					}
					else
					{
						double changePercentageDouble = ( double ) jsonObject.get( "changePercentage" );
						returnTickerData.setChangePercentage( Double.toString( changePercentageDouble ) );
					}
					
					numberObj = jsonObject.get("change");
					if ( numberObj instanceof Long )
					{
						long changeDouble = ( long ) jsonObject.get( "change" );
						returnTickerData.setChange( Long.toString( changeDouble ) );
					}
					else
					{
						double changeDouble = ( double ) jsonObject.get( "change" );
						returnTickerData.setChange( Double.toString( changeDouble ) );
					}
					
					numberObj = jsonObject.get("volume");
					if ( numberObj instanceof Long )
					{
						long volumeDouble = ( long ) jsonObject.get( "volume" );
						returnTickerData.setVolume( Long.toString( volumeDouble ) );
					}
					else
					{
						double volumeDouble = ( double ) jsonObject.get( "volume" );
						returnTickerData.setVolume( Double.toString( volumeDouble ) );
					}
					
					numberObj = jsonObject.get("dayLow");
					if ( numberObj instanceof Long )
					{
						long dayLowDouble = ( long ) jsonObject.get( "dayLow" );
						returnTickerData.setDayLow( Long.toString( dayLowDouble ) );
					}
					else
					{
						double dayLowDouble = ( double ) jsonObject.get( "dayLow" );
						returnTickerData.setDayLow( Double.toString( dayLowDouble ) );
					}
					
					numberObj = jsonObject.get("dayHigh");
					if ( numberObj instanceof Long )
					{
						long dayHighDouble = ( long ) jsonObject.get( "dayHigh" );
						returnTickerData.setDayHigh( Long.toString( dayHighDouble ) );
					}
					else
					{
						double dayHighDouble = ( double ) jsonObject.get( "dayHigh" );
						returnTickerData.setDayHigh( Double.toString( dayHighDouble ) );
					}
					
					numberObj = jsonObject.get("yearHigh");
					if ( numberObj instanceof Long )
					{
						long yearHighDouble = ( long ) jsonObject.get( "yearHigh" );
						returnTickerData.setYearHigh( Long.toString( yearHighDouble )  );
					}
					else
					{
						double yearHighDouble = ( double ) jsonObject.get( "yearHigh" );
						returnTickerData.setYearHigh( Double.toString( yearHighDouble )  );
					}
					
					numberObj = jsonObject.get("yearLow");
					if ( numberObj instanceof Long )
					{
						long yearLowDouble = ( long ) jsonObject.get( "yearLow" );
						returnTickerData.setYearLow( Long.toString( yearLowDouble ) );
					}
					else
					{
						double yearLowDouble = ( double ) jsonObject.get( "yearLow" );
						returnTickerData.setYearLow( Double.toString( yearLowDouble ) );
					}
					
					numberObj = jsonObject.get("marketCap");
					if ( numberObj instanceof Long )
					{
						long marketCapDouble = ( long ) jsonObject.get( "marketCap" );
						returnTickerData.setMarketCap( Long.toString( marketCapDouble ) );
					}
					else
					{
						double marketCapDouble = ( double ) jsonObject.get( "marketCap" );
						returnTickerData.setMarketCap( Double.toString( marketCapDouble ) );
					}
					
					numberObj = jsonObject.get("priceAvg50");
					if ( numberObj instanceof Long )
					{
						long priceAvg50Double = ( long ) jsonObject.get( "priceAvg50" );
						returnTickerData.setPriceAvg50( Long.toString( priceAvg50Double ) );
					}
					else
					{
						double priceAvg50Double = ( double ) jsonObject.get( "priceAvg50" );
						returnTickerData.setPriceAvg50( Double.toString( priceAvg50Double ) );
					}
					
					numberObj = jsonObject.get("priceAvg200");
					if ( numberObj instanceof Long )
					{
						long priceAvg200Double = ( long ) jsonObject.get( "priceAvg200" );
						returnTickerData.setPriceAvg200( Long.toString( priceAvg200Double ) );
					}
					else
					{
						double priceAvg200Double = ( double ) jsonObject.get( "priceAvg200" );
						returnTickerData.setPriceAvg200( Double.toString( priceAvg200Double ) );
					}
					
					returnTickerData.setExchange( ( String ) jsonObject.get( "exchange" )  );
					
					numberObj = jsonObject.get("open");
					if ( numberObj instanceof Long )
					{
						long openDouble = ( long ) jsonObject.get( "open" );
						returnTickerData.setOpen( Long.toString( openDouble ) );
					}
					else
					{
						double openDouble = ( double ) jsonObject.get( "open" );
						returnTickerData.setOpen( Double.toString( openDouble ) );
					}
					
					numberObj = jsonObject.get("previousClose");
					if ( numberObj instanceof Long )
					{
						long previousCloseDouble = ( long ) jsonObject.get( "previousClose" );
						returnTickerData.setPreviousClose( Long.toString( previousCloseDouble ) );
					}
					else
					{
						double previousCloseDouble = ( double ) jsonObject.get( "previousClose" );
						returnTickerData.setPreviousClose( Double.toString( previousCloseDouble ) );
					}
					
					returnTickerData.setTimestamp( currentTimestamp );
					tickerData.add( returnTickerData );
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		}
		
		ArrayList<DisplayDataBean> displayData = runAnalysis( tickerData, deltaPercent );
		return displayData;
	}
	
	private static MarketOpenBean getMarketOpen( String exchange )
	{
		MarketOpenBean open = null;
		
		String jsonMarketStatusResponse = getMarketOpenStatus( exchange );
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jsonMarketStatusArray = ( JSONArray ) parser.parse( jsonMarketStatusResponse );
			for ( Object obj : jsonMarketStatusArray ) 
			{
				open = new MarketOpenBean();
				JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
				open.setExchange( ( String ) jsonObject.get( "exchange" ) );
				open.setName( ( String ) jsonObject.get( "name" ) );
				open.setMarketOpen( ( boolean ) jsonObject.get( "isMarketOpen" ) );
				System.out.println( "Market status from API is " + open.isMarketOpen() );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		return open;
	}
			
	
	public static ArrayList<DisplayPriceToTargetBean> displayPriceToTarget( String tickers )
	{
		// parse tickers
		ArrayList<String> tickerList = new ArrayList<String>();
		String ticker = "";
		for ( Character c : tickers.toCharArray() )
			if ( c.compareTo( ',' ) != 0 )
				ticker += c;
			else
			{
				if ( ticker.length() > 0 )
				{
					ticker = ticker.trim();
					tickerList.add( ticker );
				}
				ticker = "";
			}
		
		// Pick up the last ticker on the list (or the only ticker on the list) 
		if ( ticker.length() > 0 )
		{
			ticker = ticker.trim();
			tickerList.add( ticker );
		}
		
		// First, get the ticker data
		// See if this is after hours.
		String currentNewYorkTime = getCurrentNewYorkTime();
		MarketOpenBean open = getMarketOpen( "nasdaq" );
		if ( open.isMarketOpen() )
		{
			System.out.println( "New York Time " + currentNewYorkTime + ": Loading trading hours data." );
		}
		else
		{
			System.out.println( "New York Time " + currentNewYorkTime + ": Loading after hours data." );
		}
		
		String currentTimestamp = getCurrentTimestamp();
		
		ArrayList<QuoteShortBean> tickerShortData = new ArrayList<QuoteShortBean>();
		ArrayList<QuoteAfterHoursBean> tickerAfterHoursData = new ArrayList<QuoteAfterHoursBean>();

		if ( ! open.isMarketOpen() )
		{
			for ( String element : tickerList )
			{
				String jsonAfterHoursResponse = getCurrentTickerAfterHoursProfile( element );
				JSONParser parser = new JSONParser();
				try
				{
					JSONArray jsonAfterHoursArray = ( JSONArray ) parser.parse( jsonAfterHoursResponse );
					QuoteAfterHoursBean returnAfterHoursData = new QuoteAfterHoursBean();
					for ( Object obj : jsonAfterHoursArray ) 
					{
						Object numberObj = null;
						
						JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
						returnAfterHoursData.setSymbol( ( String ) jsonObject.get( "symbol" ) );
						
						numberObj = jsonObject.get("price");
						if ( numberObj instanceof Long )
						{
							long priceDouble = ( long ) jsonObject.get( "price" );
							returnAfterHoursData.setPrice( Long.toString( priceDouble ) );
						}
						else
						{
							double priceDouble = ( double ) jsonObject.get( "price" );
							returnAfterHoursData.setPrice( Double.toString( priceDouble ) );
						}

						numberObj = jsonObject.get("tradeSize");
						if ( numberObj != null )
						{
							if ( numberObj instanceof Long )
							{
								long tradeSizeDouble = ( long ) jsonObject.get( "tradeSize" );
								returnAfterHoursData.setTradeSize( Long.toString( tradeSizeDouble ) );
							}
							else
							{
								double tradeSizeDouble = ( double ) jsonObject.get( "tradeSize" );
								returnAfterHoursData.setTradeSize( Double.toString( tradeSizeDouble ) );
							}
						}
						
						returnAfterHoursData.setTimestamp( currentTimestamp );
						tickerAfterHoursData.add( returnAfterHoursData );
					}
				}
				catch( Exception e )
				{
					e.printStackTrace();
				}
			}
		} // after hours
		else
		{
			for ( String element : tickerList )
			{
				String jsonShortProfileResponse = getCurrentTickerShortProfile( element );
				JSONParser parser = new JSONParser();
				try
				{
					JSONArray jsonShortProfileArray = ( JSONArray ) parser.parse( jsonShortProfileResponse );
					QuoteShortBean returnTickerShortData = new QuoteShortBean();
					for ( Object obj : jsonShortProfileArray ) 
					{
						Object numberObj = null;
						
						JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
						returnTickerShortData.setSymbol( ( String ) jsonObject.get( "symbol" ) );
						
						numberObj = jsonObject.get("price");
						if ( numberObj instanceof Long )
						{
							long priceDouble = ( long ) jsonObject.get( "price" );
							returnTickerShortData.setPrice( Long.toString( priceDouble ) );
						}
						else
						{
							double priceDouble = ( double ) jsonObject.get( "price" );
							returnTickerShortData.setPrice( Double.toString( priceDouble ) );
						}
	
						numberObj = jsonObject.get("change");
						if ( numberObj instanceof Long )
						{
							long changeDouble = ( long ) jsonObject.get( "change" );
							returnTickerShortData.setChange( Long.toString( changeDouble ) );
						}
						else
						{
							double changeDouble = ( double ) jsonObject.get( "change" );
							returnTickerShortData.setChange( Double.toString( changeDouble ) );
						}
						
						numberObj = jsonObject.get("volume");
						if ( numberObj instanceof Long )
						{
							long volumeDouble = ( long ) jsonObject.get( "volume" );
							returnTickerShortData.setVolume( Long.toString( volumeDouble ) );
						}
						else
						{
							double volumeDouble = ( double ) jsonObject.get( "volume" );
							returnTickerShortData.setVolume( Double.toString( volumeDouble ) );
						}
						
						returnTickerShortData.setTimestamp( currentTimestamp );
						tickerShortData.add( returnTickerShortData );
					}
				}
				catch( Exception e )
				{
					e.printStackTrace();
				}
			}
		}

		// Second, get the ticker target data
		ArrayList<TargetBean> tickerTargetData = new ArrayList<TargetBean>();
		for ( String element : tickerList )
		{
			String jsonTargetResponse = getTickerTarget( element );
			JSONParser parser = new JSONParser();
			try
			{
				JSONArray jsonTargetArray = ( JSONArray ) parser.parse( jsonTargetResponse );
				TargetBean returnTargetData = new TargetBean();
				for ( Object obj : jsonTargetArray ) 
				{
					Object numberObj = null;
					
					JSONObject jsonObject = ( JSONObject ) obj; // Each element is a JSONObject
					returnTargetData.setSymbol( ( String ) jsonObject.get( "symbol" ) );
					
					numberObj = jsonObject.get("targetHigh");
					if ( numberObj instanceof Long )
					{
						long targetHighDouble = ( long ) jsonObject.get( "targetHigh" );
						returnTargetData.setTargetHigh( Long.toString( targetHighDouble ) );
					}
					else
					{
						double targetHighDouble = ( double ) jsonObject.get( "targetHigh" );
						returnTargetData.setTargetHigh( Double.toString( targetHighDouble ) );
					}
					
					numberObj = jsonObject.get("targetLow");
					if ( numberObj instanceof Long )
					{
						long targetLowDouble = ( long ) jsonObject.get( "targetLow" );
						returnTargetData.setTargetLow( Long.toString( targetLowDouble ) );
					}
					else
					{
						double targetLowDouble = ( double ) jsonObject.get( "targetLow" );
						returnTargetData.setTargetLow( Double.toString( targetLowDouble ) );
					}
					
					numberObj = jsonObject.get("targetConsensus");
					if ( numberObj instanceof Long )
					{
						long targetConsensusDouble = ( long ) jsonObject.get( "targetConsensus" );
						returnTargetData.setTargetConsensus( Long.toString( targetConsensusDouble ) );
					}
					else
					{
						double targetConsensusDouble = ( double ) jsonObject.get( "targetConsensus" );
						returnTargetData.setTargetConsensus( Double.toString( targetConsensusDouble ) );
					}
					
					numberObj = jsonObject.get("targetMedian");
					if ( numberObj instanceof Long )
					{
						long targetMedianDouble = ( long ) jsonObject.get( "targetMedian" );
						returnTargetData.setTargetMedian( Long.toString( targetMedianDouble ) );
					}
					else
					{
						double targetMedianDouble = ( double ) jsonObject.get( "targetMedian" );
						returnTargetData.setTargetMedian( Double.toString( targetMedianDouble ) );
					}
					
					returnTargetData.setTimestamp( currentTimestamp );
					tickerTargetData.add( returnTargetData );
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		}

		ArrayList<DisplayPriceToTargetBean> displayData = combineTargetResults( tickerShortData, tickerAfterHoursData, tickerTargetData );
		return displayData;
	}
	
	public static String getUpside( String currentPrice, String targetPrice )
	{
		String upside = null;
		
		double current = 0;
		double target = 0;
		try
		{
			current = Double.parseDouble( currentPrice );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			System.out.println( "Could not parse currentPrice to double: " + currentPrice );
		}
		try
		{
			target = Double.parseDouble( targetPrice );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			System.out.println( "Could not parse targetPrice to double: " + targetPrice );
		}
		
		double x = target - current;
		
		double y = x/current;
		
		y = y * 100; // convert to percentage
		
		upside = Double.toString( y );
		
		return upside;
	}
}
