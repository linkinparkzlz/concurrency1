package com.zou.concurrency1.publish;

import com.zou.concurrency1.annotions.NotRecommand;
import com.zou.concurrency1.annotions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 在对象未被构建完成之前，不能发布
 */
@Slf4j
@NotThreadSafe
@NotRecommand
public class Escape {


    private int escape = 0;

    public Escape() {


        new InnerCalss();
    }

    private class InnerCalss {


        public InnerCalss() {

            System.out.println(Escape.this.escape);
        }

    }


    public static void main(String[] args) {


        new Escape();
    }


}






















