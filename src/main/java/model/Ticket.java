package model;

public class Ticket
{
    private Event event;
    private String ticketName;
    private int price;
    private static int numberOfTickets;

    public Event getEvent()
    {
        return event;
    }

    public void setEvent(Event event)
    {
        this.event = event;
    }

    public String getTicketName()
    {
        return ticketName;
    }

    public void setTicketName(String ticketName)
    {
        this.ticketName = ticketName;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getNumberOfTickets()
    {
        return numberOfTickets;
    }
}
