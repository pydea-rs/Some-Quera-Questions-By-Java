
abstract class DuckObject
{
	public DuckObject() {
		// whatever
	}

	public abstract void doSth();
};

class Duck extends DuckObject
{

	@Override
	public void doSth()
	{
		System.out.println("quack quack!");
		System.out.println("The Duck walked\n");
	}

	public Duck() {
		// whatever
	}
};

class Dog extends DuckObject
{

	@Override
	public void doSth()
	{
		System.out.println("Hop Hop!");
		System.out.println("The Dog walked\n");
	}

	public Dog() {
		// whatever
	}

};

class Human extends DuckObject
{

	@Override
	public void doSth()
	{
		System.out.println("Hello!");
		System.out.println("The Human walked\n");
	}

	public Human() {
		// whatever
	}
};

public class Main
{
	public static void main(String[] args)
	{
		DuckObject object = new Dog();
		DuckObject object1 = new Duck();
		DuckObject object2 = new Human();

		DuckObject[] objects = new DuckObject[3];
		objects[0] = object;
		objects[1] = object1;
		objects[2] = object2;

		for (DuckObject myObjects : objects) {
			myObjects.doSth();
		}

	}
};


