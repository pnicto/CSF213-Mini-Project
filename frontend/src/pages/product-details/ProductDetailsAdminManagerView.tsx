import {
  Button,
  Grid,
  Image,
  NumberInput,
  Stack,
  Switch,
  Textarea,
  TextInput,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { useState } from "react";
import { Product } from "../../types/interfaces";

type Props = {
  product: Product;
};

const ProductDetailsAdminManagerView = ({ product }: Props) => {
  const { name, description, price, imageUrl, deliveryTime } = product;
  const [isAvailable, setIsAvailable] = useState(product.isAvailable);

  const form = useForm({
    initialValues: {
      name,
      description,
      imageUrl,
      price,
      deliveryTime,
    },
  });

  return (
    <>
      <Grid.Col span={3} offset={2}>
        <TextInput
          withAsterisk
          required
          label="Link to image"
          value={imageUrl}
          {...form.getInputProps("imageUrl")}
        />
        <Image
          alt={name}
          src={imageUrl}
          withPlaceholder
          height={500}
          fit="contain"
        />
      </Grid.Col>
      <Grid.Col span={7} offset={1}>
        <Stack align={"flex-start"}>
          <TextInput
            withAsterisk
            required
            label="Name"
            {...form.getInputProps("name")}
            w={"40%"}
          />
          <Switch
            required
            label="Is in stock?"
            checked={isAvailable}
            onChange={(event) => setIsAvailable(event.currentTarget.checked)}
          />
          <NumberInput
            withAsterisk
            required
            precision={2}
            label="Price in &#8377;"
            min={1}
            step={50}
            {...form.getInputProps("price")}
          />
          <NumberInput
            withAsterisk
            required
            label="Delivery time in days"
            min={1}
            {...form.getInputProps("deliveryTime")}
          />
          <Textarea
            withAsterisk
            w={"70%"}
            required
            autosize
            label="Description"
            {...form.getInputProps("description")}
          />
          <Button onClick={() => {}}>Apply edits</Button>
        </Stack>
      </Grid.Col>
    </>
  );
};

export default ProductDetailsAdminManagerView;
