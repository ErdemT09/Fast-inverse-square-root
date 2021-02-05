/*Originally written for the game Quake III Arena
More Information at: https://en.wikipedia.org/wiki/Fast_inverse_square_root*/

public class Main
{
public static float invSqrt(float x) {
    //Reference: https://stackoverflow.com/a/11513345
    
    float xhalf = 0.5f * x;
    int i = Float.floatToIntBits(x);
    i = 0x5f3759df - (i >> 1);
    x = Float.intBitsToFloat(i);
    x *= (1.5f - xhalf * x * x);
    
    //x *= number;
    //The multiplication above would result in the square root of the number
    
    return x;
}
public static double Q_rsqrt(double number){
    //Reference: https://stackoverflow.com/a/20897211
    
    //More accurate but slower version for doubles
    double x = number;
    double xhalf = 0.5d*x;
    long i = Double.doubleToLongBits(x);
    i = 0x5fe6ec85e7de30daL - (i>>1);
    x = Double.longBitsToDouble(i);
    for(int it = 0; it < 4; it++){
        x = x*(1.5d - xhalf*x*x);
    }
    //This one iterates through the Newton's method a few more times
    
    //x *= number;
    //The multiplication above would result in the square root of the number
    return x;
}
	public static void main(String[] args) {
		System.out.println(Q_rsqrt(4)); //Prints 0.5
		System.out.println(invSqrt(4f)); //Prints 0.49915358
	}
}