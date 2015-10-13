package com.beautydroid.footballz.core.api;

import com.beautydroid.footballz.core.api.msg.ErrorMsg;
import com.beautydroid.footballz.core.api.msg.SeasonMsg;

import java.util.List;

public interface IFootballData extends IToken {
    interface ICallback<S, E> {
        void onSuccess(S successMsg);

        void onError(E errorMsg);

        void onException(Exception ex);
    }
    void listSeason(int season, ICallback<List<SeasonMsg>, ErrorMsg> callback);
}
