class Polymorphism {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        Rectangle[] rectangles = new Rectangle[3];
        Graphic[] graphics = new Graphic[3]; // 可以存储各种图形对象
        graphics[0] = new Circle(1.2);
        Graphic g1 = new Rectangle(2, 4); //多态
        graphics[1] = g1;
    }

    // Polymorphism
    public static void check(Animal animal) {
        animal.eat();
    }

    // Overload
    public static void check(Dog dog) {
        dog.eat();
    }
    public static void check(Cat cat) {
        cat.eat();
    }


    static class Animal {
        public void eat() {
            System.out.println("EAT");
        }
    }

    static class Dog extends Animal {
        public void eat() {
            System.out.println("EAT BONES");
        }

    }

    static class Cat extends Animal {
        public void eat() {
            System.out.println("EAT FISH");
        }
    }

    static class Graphic {
        public Graphic() {}
        public double getArea() {
            return 0.0;
        }
    }

    static class Circle extends Graphic {
        private double radius;
        public Circle(double radius) {
            super();
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return 3.14 * radius * radius;
        }
    }

    static class Rectangle extends Graphic {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            super();
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }
    }
}