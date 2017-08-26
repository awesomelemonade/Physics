package lemon.engine.math;

public class MathUtil {
	
	private MathUtil() {}

	public static boolean[] convertMods(int bitset) {
		boolean[] mods = new boolean[4];
		if ((bitset & (1 << 0)) == 1) mods[0] = true;
		if ((bitset & (1 << 1)) == 1) mods[1] = true;
		if ((bitset & (1 << 2)) == 1) mods[2] = true;
		if ((bitset & (1 << 3)) == 1) mods[3] = true;
		return mods;
	}
	public static float toRadians(float degrees){
		return (float) Math.toRadians(degrees);
	}
	public static float toDegrees(float radians){
		return (float) Math.toDegrees(radians);
	}
	public static Matrix getPerspective(Projection projection){
		Matrix matrix = new Matrix(4);
		float yScale = (float)(1/Math.tan(Math.toRadians(projection.getFov()/2)));
		float xScale = yScale/projection.getAspectRatio();
		matrix.set(0, 0, xScale);
		matrix.set(1, 1, yScale);
		matrix.set(2, 2, -(projection.getNearPlane()+projection.getFarPlane())/(projection.getFarPlane()-projection.getNearPlane()));
		matrix.set(2, 3, (-2*projection.getNearPlane()*projection.getFarPlane())/(projection.getFarPlane()-projection.getNearPlane()));
		matrix.set(3, 2, -1);
		matrix.set(3, 3, 0);
		return matrix;
	}
	public static Matrix getOrtho(float width, float height, float near, float far){
		Matrix matrix = new Matrix(4);
		matrix.set(0, 0, 2f/width);
		matrix.set(1, 1, 2f/height);
		matrix.set(2, 2, 1f/(far-near));
		matrix.set(0, 3, -1f);
		matrix.set(1, 3, -1f);
		matrix.set(2, 3, (-near)/(far-near));
		matrix.set(3, 3, 1);
		return matrix;
	}
	public static Matrix getTranslation(Vector3D vector){
		Matrix matrix = Matrix.getIdentity(4);
		matrix.set(0, 3, vector.getX());
		matrix.set(1, 3, vector.getY());
		matrix.set(2, 3, vector.getZ());
		return matrix;
	}
	public static Matrix getRotationX(float angle){
		Matrix matrix = new Matrix(4);
		float sin = (float) Math.sin(Math.toRadians(angle));
		float cos = (float) Math.cos(Math.toRadians(angle));
		matrix.set(0, 0, 1);
		matrix.set(1, 1, cos);
		matrix.set(2, 1, sin);
		matrix.set(1, 2, -sin);
		matrix.set(2, 2, cos);
		matrix.set(3, 3, 1);
		return matrix;
	}
	public static Matrix getRotationY(float angle){
		Matrix matrix = new Matrix(4);
		float sin = (float) Math.sin(Math.toRadians(angle));
		float cos = (float) Math.cos(Math.toRadians(angle));
		matrix.set(0, 0, cos);
		matrix.set(1, 1, 1);
		matrix.set(2, 0, -sin);
		matrix.set(0, 2, sin);
		matrix.set(2, 2, cos);
		matrix.set(3, 3, 1);
		return matrix;
	}
	public static Matrix getRotationZ(float angle){
		Matrix matrix = new Matrix(4);
		float sin = (float) Math.sin(Math.toRadians(angle));
		float cos = (float) Math.cos(Math.toRadians(angle));
		matrix.set(0, 0, cos);
		matrix.set(0, 1, sin);
		matrix.set(1, 0, -sin);
		matrix.set(1, 1, cos);
		matrix.set(2, 2, 1);
		matrix.set(3, 3, 1);
		return matrix;
	}
	public static Matrix getScalar(Vector3D vector){
		Matrix matrix = new Matrix(4);
		matrix.set(0, 0, vector.getX());
		matrix.set(1, 1, vector.getY());
		matrix.set(2, 2, vector.getZ());
		matrix.set(3, 3, 1);
		return matrix;
	}
}
