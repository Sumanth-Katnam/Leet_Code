package leetCode.MathAndGeomerty.Hard;

public class ReachingPoints_780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty)
            return true;

        while (!(sx == tx && sy == ty)){
            if(sx > tx || sy > ty)
                return false;
            else if(tx == ty)
                return (0 == sx && ty == sy) || (tx == sx && 0 == sy);

            if(ty > tx){
                if(tx == sx)
                    return (ty - sy) % sx == 0;
                ty %= tx;
            } else{
                if(ty == sy)
                    return (tx - sx) % sy == 0;
                tx %= ty;
            }

        }
        return true;
    }

}
