package com.notificationpanel.Formatting.FormatOptions;

import lombok.Getter;
import lombok.Setter;

public class OpacityOption extends KeyValueOption {
    @Getter
    private int opacity;

    @Getter
    @Setter
    private static int defaultOpacity = 100;

    public OpacityOption()
    {
        super("opacity", String.valueOf(defaultOpacity));
    }
    public OpacityOption(int opacity) {
        super("opacity", String.valueOf(opacity));
        this.opacity = opacity;
    }

    // TODO: decide on the best way to ignore exceptions here
    public OpacityOption parse(String input) throws Exception {
        KeyValueOption option = super.parse(input);
        if (option == null) {
            return null;
        }
        return new OpacityOption(Integer.parseInt(option.getValue()));
    }
}

