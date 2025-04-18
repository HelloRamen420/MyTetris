public class Mino {
    int mino[][][];

    Mino(int mino[][][]) {
        this.mino = mino;
    }

    Mino() {
    };

    public int getMino(int i1, int i2, int i3) {
        return this.mino[i1][i2][i3];
    }

    static int[][][] tM = {
            { { 0, 5, 0 }, { 5, 5, 5 } },
            { { 0, 5, 0 }, { 0, 5, 5 }, { 0, 5, 0 } },
            { { 5, 5, 5 }, { 0, 5, 0 } },
            { { 0, 5, 0 }, { 5, 5, 0 }, { 0, 5, 0 } }
    };
    static int[][][] iM = {
            { { 0, 0, 0, 0 }, { 6, 6, 6, 6 } },
            { { 0, 0, 6 }, { 0, 0, 6 }, { 0, 0, 6 }, { 0, 0, 6 } },
            { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 6, 6, 6, 6 } },
            { { 0, 6 }, { 0, 6 }, { 0, 6 }, { 0, 6 } }
    };
    static int[][][] oM = {
            { { 7, 7 }, { 7, 7 } },
            { { 7, 7 }, { 7, 7 } },
            { { 7, 7 }, { 7, 7 } },
            { { 7, 7 }, { 7, 7 } }
    };
    static int[][][] sM = {
            { { 0, 2, 2 }, { 2, 2, 0 } },
            { { 0, 2, 0 }, { 0, 2, 2 }, { 0, 0, 2 } },
            { { 0, 0, 0 }, { 0, 2, 2 }, { 2, 2, 0 } },
            { { 2, 0, 0 }, { 2, 2, 0 }, { 0, 2, 0 } },
    };
    static int[][][] zM = {
            { { 1, 1, 0 }, { 0, 1, 1 } },
            { { 0, 0, 1 }, { 0, 1, 1 }, { 0, 1, 0 } },
            { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 1, 1 } },
            { { 0, 1, 0 }, { 1, 1, 0 }, { 1, 0, 0 } }
    };
    static int[][][] lM = {
            { { 0, 0, 4 }, { 4, 4, 4 } },
            { { 0, 4, 0 }, { 0, 4, 0 }, { 0, 4, 4 } },
            { { 0, 0, 0 }, { 4, 4, 4 }, { 4, 0, 0 } },
            { { 4, 4, 0 }, { 0, 4, 0 }, { 0, 4, 0 } }
    };
    static int[][][] jM = {
            { { 3, 0, 0 }, { 3, 3, 3 } },
            { { 0, 3, 3 }, { 0, 3, 0 }, { 0, 3, 0 } },
            { { 0, 0, 0 }, { 3, 3, 3 }, { 0, 0, 3 } },
            { { 0, 3, 0 }, { 0, 3, 0 }, { 3, 3, 0 } }
    };
}
