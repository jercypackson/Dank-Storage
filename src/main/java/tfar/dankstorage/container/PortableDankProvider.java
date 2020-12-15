package tfar.dankstorage.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import tfar.dankstorage.inventory.PortableDankHandler;
import tfar.dankstorage.utils.DankStats;
import tfar.dankstorage.utils.Utils;

import javax.annotation.Nullable;

public class PortableDankProvider implements INamedContainerProvider {

  public final ItemStack bag;
  private final Hand hand;

  public PortableDankProvider(ItemStack bag, Hand hand) {
    this.bag = bag;
    this.hand = hand;
  }

  @Override
  public ITextComponent getDisplayName() {
    return bag.getDisplayName();
  }

  @Nullable
  @Override
  public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity player) {

    PortableDankHandler handler = Utils.getHandler(bag,hand);

    DankStats stats = Utils.getStats(bag);

    int selectedSlot = Utils.getSelectedSlot(bag);

    IIntArray array = new PortableDankContainerData(handler,selectedSlot);

    switch (stats) {
      case one:
      default:
        return PortableDankContainer.dank1s(i, playerInventory,handler,array);
      case two:
        return PortableDankContainer.dank2s(i, playerInventory,handler,array);
      case three:
        return PortableDankContainer.dank3s(i, playerInventory, handler,array);
      case four:
        return PortableDankContainer.dank4s(i, playerInventory,handler,array);
      case five:
        return PortableDankContainer.dank5s(i, playerInventory, handler,array);
      case six:
        return PortableDankContainer.dank6s(i, playerInventory, handler,array);
      case seven:
        return PortableDankContainer.dank7s(i, playerInventory, handler,array);
    }
  }
}
