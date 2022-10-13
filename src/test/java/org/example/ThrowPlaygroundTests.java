package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author kiyota
 */
class ThrowPlaygroundTests {

    @Test
    void existFile() throws Exception {
        ThrowPlayground sut = new ThrowPlayground();

        String fileName = "test.txt";

        sut.throwPlayground(fileName);
        assertThat(sut.isFinished()).isTrue();
    }

    @DisplayName("throw した場合はその後の処理は走っていないことの確認")
    @Test
    void notExistFile() {
        ThrowPlayground sut = new ThrowPlayground();

        String fileName = "not_exist.txt";

        assertThatThrownBy(() -> sut.throwPlayground(fileName))
                .isInstanceOf(Exception.class);

        assertThat(sut.isFinished()).isFalse();
    }
}