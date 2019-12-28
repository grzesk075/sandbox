package pl.grzesk075.sandbox.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static pl.grzesk075.sandbox.leetcode.GuessTheWord.Master;

public class GuessTheWordTest {

    @Test
    public void shouldFindSecretWord() {
        final String[] wordList = {"abcdef", "acckzz", "ccbazz", "eiowzz", "abcczz"};
        final Master master = s -> GuessTheWord.match(s, "acckzz");
        new GuessTheWord().findSecretWord(wordList, master);
    }

    @Test
    public void shouldFindSecretWordLeetCodeTest() {
        final String[] wordList = {"wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg",
                "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro",
                "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg", "tqxlbr",
                "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp", "szgupv", "qpxmsw",
                "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt",
                "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh", "wynohw",
                "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc",
                "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb", "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda",
                "kaefne", "swcrkh", "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki",
                "zcffuv", "srxuus", "pydgmq"};
        final Master master = s -> GuessTheWord.match(s, "ccoyyo");
        new GuessTheWord().findSecretWord(wordList, master);
    }

    @Test
    public void shouldDoMatch() {
        assertEquals(0, GuessTheWord.match("urytre", "dkjjha"));
        assertEquals(6, GuessTheWord.match("urytre", "urytre"));
        assertEquals(1, GuessTheWord.match("aaajay", "dkjjha"));
    }
}