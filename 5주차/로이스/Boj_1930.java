package Royce.practice;

//https://www.acmicpc.net/problem/1930

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1930 {

    private static final int TETRAHEDRON_FACE_AMOUNT = 4;

    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            System.out.println(isSameTetrahedron(br) ? 1 : 0);
        }
    }

    private static boolean isSameTetrahedron(final BufferedReader br) throws IOException {
        final int[] tetrahedronA = new int[TETRAHEDRON_FACE_AMOUNT + 2];
        final int[] tetrahedronB = new int[TETRAHEDRON_FACE_AMOUNT];
        final short[] colors = new short[60001];

        final StringTokenizer infos = new StringTokenizer(br.readLine());
        for (int j = 0; j < TETRAHEDRON_FACE_AMOUNT; j++) {
            final int color = Integer.parseInt(infos.nextToken());
            colors[color]++;
            tetrahedronA[j] = color;
            if (j == 1 || j == 2) {
                tetrahedronA[j + 3] = color;
            }
        }

        final Set<Integer> baseRotateSet = new HashSet<>();
        for (int j = 0; j < TETRAHEDRON_FACE_AMOUNT; j++) {
            final int color = Integer.parseInt(infos.nextToken());
            if (colors[color] == 0) {
                return false;
            }

            if (color == tetrahedronA[0]) {
                baseRotateSet.add(j);
            }
            tetrahedronB[j] = color;
            colors[color]--;
        }

        if (colors[tetrahedronA[0]] != 0
                || colors[tetrahedronA[1]] != 0
                || colors[tetrahedronA[2]] != 0
                || colors[tetrahedronA[3]] != 0) {
            return false;
        }

        if (baseRotateSet.contains(1)) {
            final int[] rotatedTetrahedronB = new int[]{
                    tetrahedronB[1],
                    tetrahedronB[0],
                    tetrahedronB[3],
                    tetrahedronB[2]
            };
            if (isSameSideFaceColors(tetrahedronA, rotatedTetrahedronB)) {
                return true;
            }
        }

        if (baseRotateSet.contains(2)) {
            final int[] rotatedTetrahedronB = new int[]{
                    tetrahedronB[2],
                    tetrahedronB[3],
                    tetrahedronB[0],
                    tetrahedronB[1]
            };
            if (isSameSideFaceColors(tetrahedronA, rotatedTetrahedronB)) {
                return true;
            }
        }

        if (baseRotateSet.contains(3)) {
            final int[] rotatedTetrahedronB = new int[]{
                    tetrahedronB[3],
                    tetrahedronB[2],
                    tetrahedronB[1],
                    tetrahedronB[0]
            };
            if (isSameSideFaceColors(tetrahedronA, rotatedTetrahedronB)) {
                return true;
            }
        }

        return isSameSideFaceColors(tetrahedronA, tetrahedronB);
    }

    private static boolean isSameSideFaceColors(final int[] tetrahedronA, final int[] tetrahedronB) {
        // 1 2 3 4 2 3
        // 1 4 2 3

        for (int i = 1; i < 4; i++) {
            if (tetrahedronB[1] == tetrahedronA[i]
                    && tetrahedronB[2] == tetrahedronA[i + 1]
                    && tetrahedronB[3] == tetrahedronA[i + 2]) {
                return true;
            }
        }

        return false;
    }
}
