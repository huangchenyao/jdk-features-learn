package com.abc.jdk7;

/*
 * 整型类型的二进制表示
 * 在Java 7中，整型类型(byte, short, int, and long)可以使用二进制来表示，要使用二进制表示，需要增加前缀0b或者0B
 */
public class BinaryLiterals {
    // Java 7之前，可以使用八进制，十进制，十六进制表示
    int oct = 0777;
    int dec = 4396;
    int hex = 0x4396FF;

    // 8位的byte类型
    byte aByte = (byte) 0b00100001;

    // 16位的short类型
    short aShort = (short) 0b1010000101000101;

    // 32位的int类型
    int anInt1 = 0b10100001010001011010000101000101;
    int anInt2 = 0b101;
    int anInt3 = 0B101; // 0b, 0B不区分大小写

    // 64位的long类型，要加上L后缀
    long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;

    // 与十进制、十六进制相比，二进制表示会让数据之间的关系更加清晰
    // 下面的例子中，数组中的每一位都是上一位循环左移后的结果
    public static final int[] phaseBin = {
            0b00110001,
            0b01100010,
            0b11000100,
            0b10001001,
            0b00010011,
            0b00100110,
            0b01001100,
            0b10011000
    };
    // 用十六进制表示，数据的关系看起来就没那么清晰了
    public static final int[] phasesHex = {
            0x31, 0x62, 0xC4, 0x89, 0x13, 0x26, 0x4C, 0x98
    };

    // 可以在代码中使用二进制常量，方便根据规范文档进行验证
    // 例如8位微处理器的模拟器
    public State decodeInstruction(int instruction, State state) {
        if ((instruction & 0b11100000) == 0b00000000) {
            final int register = instruction & 0b00001111;
            switch (instruction & 0b11110000) {
                case 0b00000000:
                    return state.nop();
                case 0b00010000:
                    return state.copyAccumTo(register);
                case 0b00100000:
                    return state.addToAccum(register);
                case 0b00110000:
                    return state.subFromAccum(register);
                case 0b01000000:
                    return state.multiplyAccumBy(register);
                case 0b01010000:
                    return state.divideAccumBy(register);
                case 0b01100000:
                    return state.setAccumFrom(register);
                case 0b01110000:
                    return state.returnFromCall();
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            final int address = instruction & 0b00011111;
            switch (instruction & 0b11100000) {
                case 0b00100000:
                    return state.jumpTo(address);
                case 0b01000000:
                    return state.jumpIfAccumZeroTo(address);
                case 0b01100000:
                    return state.jumpIfAccumNonzeroTo(address);
                case 0b10000000:
                    return state.setAccumFromMemory(address);
                case 0b10100000:
                    return state.writeAccumToMemory(address);
                case 0b11000000:
                    return state.callTo(address);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    // 使用二进制让位图更具有可读性
    public static final short[] HAPPY_FACE = {
            (short) 0b0000011111100000,
            (short) 0b0000100000010000,
            (short) 0b0001000000001000,
            (short) 0b0010000000000100,
            (short) 0b0100000000000010,
            (short) 0b1000011001100001,
            (short) 0b1000011001100001,
            (short) 0b1000000000000001,
            (short) 0b1000000000000001,
            (short) 0b1001000000001001,
            (short) 0b1000100000010001,
            (short) 0b0100011111100010,
            (short) 0b0010000000000100,
            (short) 0b0001000000001000,
            (short) 0b0000100000010000,
            (short) 0b0000011111100000
    };

    private class State {
        State nop() {
            return this;
        }

        State copyAccumTo(int register) {
            return this;
        }

        State addToAccum(int register) {
            return this;
        }

        State subFromAccum(int register) {
            return this;
        }

        State multiplyAccumBy(int register) {
            return this;
        }

        State divideAccumBy(int register) {
            return this;
        }

        State setAccumFrom(int register) {
            return this;
        }

        State returnFromCall() {
            return this;
        }

        State jumpTo(int address) {
            return this;
        }

        State jumpIfAccumZeroTo(int address) {
            return this;
        }

        State jumpIfAccumNonzeroTo(int address) {
            return this;
        }

        State setAccumFromMemory(int address) {
            return this;
        }

        State writeAccumToMemory(int address) {
            return this;
        }

        State callTo(int address) {
            return this;
        }
    }

}
