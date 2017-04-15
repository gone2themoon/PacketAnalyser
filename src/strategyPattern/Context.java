package strategyPattern;

public class Context {
	   private Strategy strategy;
	   
	   //   Context context = new Context(new DayTime());

	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public int executeStrategy(String colour){
	      return strategy.doOperation(colour);
	   }
	}