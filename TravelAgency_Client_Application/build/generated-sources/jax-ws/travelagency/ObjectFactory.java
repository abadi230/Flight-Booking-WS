
package travelagency;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the travelagency package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Book_QNAME = new QName("http://travelagency/", "Book");
    private final static QName _GetConversionRateResponse_QNAME = new QName("http://travelagency/", "GetConversionRateResponse");
    private final static QName _BookResponse_QNAME = new QName("http://travelagency/", "BookResponse");
    private final static QName _OriginAirport_QNAME = new QName("http://travelagency/", "originAirport");
    private final static QName _GetCurrencyCodesResponse_QNAME = new QName("http://travelagency/", "GetCurrencyCodesResponse");
    private final static QName _GetConversionRate_QNAME = new QName("http://travelagency/", "GetConversionRate");
    private final static QName _DestinationCities_QNAME = new QName("http://travelagency/", "destinationCities");
    private final static QName _SearchFlightResponse_QNAME = new QName("http://travelagency/", "SearchFlightResponse");
    private final static QName _OriginAirportResponse_QNAME = new QName("http://travelagency/", "originAirportResponse");
    private final static QName _DestinationCitiesResponse_QNAME = new QName("http://travelagency/", "destinationCitiesResponse");
    private final static QName _OriginCitiesResponse_QNAME = new QName("http://travelagency/", "originCitiesResponse");
    private final static QName _DestinationAirport_QNAME = new QName("http://travelagency/", "destinationAirport");
    private final static QName _OriginCities_QNAME = new QName("http://travelagency/", "originCities");
    private final static QName _DestinationAirportResponse_QNAME = new QName("http://travelagency/", "destinationAirportResponse");
    private final static QName _GetCurrencyCodes_QNAME = new QName("http://travelagency/", "GetCurrencyCodes");
    private final static QName _SearchFlight_QNAME = new QName("http://travelagency/", "SearchFlight");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: travelagency
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OriginCitiesResponse }
     * 
     */
    public OriginCitiesResponse createOriginCitiesResponse() {
        return new OriginCitiesResponse();
    }

    /**
     * Create an instance of {@link DestinationCitiesResponse }
     * 
     */
    public DestinationCitiesResponse createDestinationCitiesResponse() {
        return new DestinationCitiesResponse();
    }

    /**
     * Create an instance of {@link SearchFlightResponse }
     * 
     */
    public SearchFlightResponse createSearchFlightResponse() {
        return new SearchFlightResponse();
    }

    /**
     * Create an instance of {@link OriginAirportResponse }
     * 
     */
    public OriginAirportResponse createOriginAirportResponse() {
        return new OriginAirportResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyCodes }
     * 
     */
    public GetCurrencyCodes createGetCurrencyCodes() {
        return new GetCurrencyCodes();
    }

    /**
     * Create an instance of {@link SearchFlight }
     * 
     */
    public SearchFlight createSearchFlight() {
        return new SearchFlight();
    }

    /**
     * Create an instance of {@link DestinationAirportResponse }
     * 
     */
    public DestinationAirportResponse createDestinationAirportResponse() {
        return new DestinationAirportResponse();
    }

    /**
     * Create an instance of {@link OriginCities }
     * 
     */
    public OriginCities createOriginCities() {
        return new OriginCities();
    }

    /**
     * Create an instance of {@link DestinationAirport }
     * 
     */
    public DestinationAirport createDestinationAirport() {
        return new DestinationAirport();
    }

    /**
     * Create an instance of {@link BookResponse }
     * 
     */
    public BookResponse createBookResponse() {
        return new BookResponse();
    }

    /**
     * Create an instance of {@link OriginAirport }
     * 
     */
    public OriginAirport createOriginAirport() {
        return new OriginAirport();
    }

    /**
     * Create an instance of {@link GetConversionRateResponse }
     * 
     */
    public GetConversionRateResponse createGetConversionRateResponse() {
        return new GetConversionRateResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link DestinationCities }
     * 
     */
    public DestinationCities createDestinationCities() {
        return new DestinationCities();
    }

    /**
     * Create an instance of {@link GetConversionRate }
     * 
     */
    public GetConversionRate createGetConversionRate() {
        return new GetConversionRate();
    }

    /**
     * Create an instance of {@link GetCurrencyCodesResponse }
     * 
     */
    public GetCurrencyCodesResponse createGetCurrencyCodesResponse() {
        return new GetCurrencyCodesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Book }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "Book")
    public JAXBElement<Book> createBook(Book value) {
        return new JAXBElement<Book>(_Book_QNAME, Book.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "GetConversionRateResponse")
    public JAXBElement<GetConversionRateResponse> createGetConversionRateResponse(GetConversionRateResponse value) {
        return new JAXBElement<GetConversionRateResponse>(_GetConversionRateResponse_QNAME, GetConversionRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "BookResponse")
    public JAXBElement<BookResponse> createBookResponse(BookResponse value) {
        return new JAXBElement<BookResponse>(_BookResponse_QNAME, BookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OriginAirport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "originAirport")
    public JAXBElement<OriginAirport> createOriginAirport(OriginAirport value) {
        return new JAXBElement<OriginAirport>(_OriginAirport_QNAME, OriginAirport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyCodesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "GetCurrencyCodesResponse")
    public JAXBElement<GetCurrencyCodesResponse> createGetCurrencyCodesResponse(GetCurrencyCodesResponse value) {
        return new JAXBElement<GetCurrencyCodesResponse>(_GetCurrencyCodesResponse_QNAME, GetCurrencyCodesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "GetConversionRate")
    public JAXBElement<GetConversionRate> createGetConversionRate(GetConversionRate value) {
        return new JAXBElement<GetConversionRate>(_GetConversionRate_QNAME, GetConversionRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestinationCities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "destinationCities")
    public JAXBElement<DestinationCities> createDestinationCities(DestinationCities value) {
        return new JAXBElement<DestinationCities>(_DestinationCities_QNAME, DestinationCities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFlightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "SearchFlightResponse")
    public JAXBElement<SearchFlightResponse> createSearchFlightResponse(SearchFlightResponse value) {
        return new JAXBElement<SearchFlightResponse>(_SearchFlightResponse_QNAME, SearchFlightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OriginAirportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "originAirportResponse")
    public JAXBElement<OriginAirportResponse> createOriginAirportResponse(OriginAirportResponse value) {
        return new JAXBElement<OriginAirportResponse>(_OriginAirportResponse_QNAME, OriginAirportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestinationCitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "destinationCitiesResponse")
    public JAXBElement<DestinationCitiesResponse> createDestinationCitiesResponse(DestinationCitiesResponse value) {
        return new JAXBElement<DestinationCitiesResponse>(_DestinationCitiesResponse_QNAME, DestinationCitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OriginCitiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "originCitiesResponse")
    public JAXBElement<OriginCitiesResponse> createOriginCitiesResponse(OriginCitiesResponse value) {
        return new JAXBElement<OriginCitiesResponse>(_OriginCitiesResponse_QNAME, OriginCitiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestinationAirport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "destinationAirport")
    public JAXBElement<DestinationAirport> createDestinationAirport(DestinationAirport value) {
        return new JAXBElement<DestinationAirport>(_DestinationAirport_QNAME, DestinationAirport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OriginCities }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "originCities")
    public JAXBElement<OriginCities> createOriginCities(OriginCities value) {
        return new JAXBElement<OriginCities>(_OriginCities_QNAME, OriginCities.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestinationAirportResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "destinationAirportResponse")
    public JAXBElement<DestinationAirportResponse> createDestinationAirportResponse(DestinationAirportResponse value) {
        return new JAXBElement<DestinationAirportResponse>(_DestinationAirportResponse_QNAME, DestinationAirportResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyCodes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "GetCurrencyCodes")
    public JAXBElement<GetCurrencyCodes> createGetCurrencyCodes(GetCurrencyCodes value) {
        return new JAXBElement<GetCurrencyCodes>(_GetCurrencyCodes_QNAME, GetCurrencyCodes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFlight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://travelagency/", name = "SearchFlight")
    public JAXBElement<SearchFlight> createSearchFlight(SearchFlight value) {
        return new JAXBElement<SearchFlight>(_SearchFlight_QNAME, SearchFlight.class, null, value);
    }

}
