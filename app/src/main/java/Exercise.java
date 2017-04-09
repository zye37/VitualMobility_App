import com.example.zye37.capstone.ExerciseType;

/**
 * Created by zye37 on 4/9/2017.
 */

public class Exercise {
    public static final String EXERCISE_KEY = "exerciseKey"; // for Firebase path



    private ExerciseType type;
    private String exerciseName;

    public Exercise() {

    }

    public Exercise(ExerciseType type, String exerciseName) {
        this.type = type;
        this.exerciseName = exerciseName;
    }

}
