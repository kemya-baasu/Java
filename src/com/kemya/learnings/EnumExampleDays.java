package com.kemya.learnings;
enum EnumExampleDays implements DailyScheduler{
    MONDAY("To succeed in life, you need three things: a wishbone, a backbone, and a funny bone"),TUESDAY("It's kind of fun to do the impossible"),WEDNESDAY("Everything you want is on the other side of fear"),THURSDAY("The difference between winning and losing is most often not quitting"),FRIDAY("Do you give as much energy to your dreams as you do to your fears?"),SATURDAY("You cannot swim for new horizons until you have courage to lose sight of the shore"),SUNDAY{
        @Override
        public void PrintQuotes(String Quotes) {
            System.out.println("Sorry no Quotes Today! Leave for the Organization");
            quotes="Sorry no Quotes Today! Leave for the Organization";
        }
    };
    String quotes;
    EnumExampleDays(String QuotesForTheDay){
        System.out.println(this.ordinal());
        quotes=QuotesForTheDay;
    }

    EnumExampleDays() {

    }

    public static void main(String args[]){
         EnumExampleDays[] enumArray = EnumExampleDays.values();
        for (EnumExampleDays e:enumArray) {
            e.PrintQuotes(e.quotes);
        }
    }

    @Override
    public void PrintQuotes(String Quotes) {
        System.out.println(Quotes);
    }
}
interface DailyScheduler{
     void PrintQuotes(String Quotes);
}


