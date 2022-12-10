package com.notificationpanel.ConditionalFormatting;

import com.notificationpanel.ConditionalFormatting.FormatOptions.ColorOption;
import com.notificationpanel.ConditionalFormatting.FormatOptions.OpacityOption;
import com.notificationpanel.ConditionalFormatting.FormatOptions.VisibilityOption;
import com.notificationpanel.NotificationPanelConfig;
import lombok.Getter;

import java.awt.Color;

public class NotificationFormat {
    @Getter
    private final Color color;
    @Getter
    private final Boolean isVisible;
    @Getter
    private final Integer opacity;

    public NotificationFormat(PartialFormat options, NotificationPanelConfig config) {
        PartialFormat optionsWithDefaults = options.mergeWithDefaults(config);
        this.color = optionsWithDefaults.getOptionOfType(ColorOption.class).getColor();
        this.isVisible = optionsWithDefaults.getOptionOfType(VisibilityOption.class).isVisible();
        this.opacity = optionsWithDefaults.getOptionOfType(OpacityOption.class).getOpacity();
    }

    public Color getColorWithOpacity() {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), opacity);
    }
}
